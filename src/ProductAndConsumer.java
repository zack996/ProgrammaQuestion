public class ProductAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(product,"生产者A").start();
        new Thread(product,"生产者B").start();
        new Thread(consumer,"消费者A").start();
        new Thread(consumer,"消费者B").start();

    }
    static class Clerk{
        private int product = 0;
        public synchronized void get(){
            while(product>=1){
                System.out.println("仓库已满");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName()+":"+ ++product);
            this.notifyAll();

        }

        public synchronized void sell(){
            while(product<=0){
                System.out.println("已售光");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+ --product);
            this.notifyAll();
        }
    }

    static class Product implements Runnable{
        private Clerk clerk = null;


        public Product(Clerk clerk){
            this.clerk=clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.get();
            }
        }

    }

    static class Consumer implements Runnable{
        private Clerk clerk = null;

        public Consumer(Clerk clerk){
            this.clerk=clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.sell();
            }
        }

    }
}
