public class ProductExample {

    public static void main(String[] args) {
        Director director = new Director();
        Director director1 = new Director();
        ProductBuilder milkBuilder = new MilkProductBuilder();
        ProductBuilder slipperBuilder = new SlippersProductBuilder();

        director.setProductBuilder(milkBuilder);
        System.out.println(director.foodProductConstructor());
        director1.setProductBuilder(slipperBuilder);
        System.out.println(director1.shoesProductConstructor());


    }
}
