import java.util.List;

public class SOLID_O {
        public static void main(String[] args) {
                Product apple = new Product("Apple", Color.GREEN, Size.SMALL, Price.FIVE);
                Product tree = new Product("Tree", Color.GREEN, Size.LARGE, Price.FIVE);
                Product house = new Product("House", Color.BLUE, Size.LARGE, Price.FIFTEEN);

                List<Product> products = List.of(apple, tree, house);

                ProductFilter pf = new ProductFilter();
                System.out.println("Green products: (new)");
                pf.filter(products, new ColorSpecification(Color.GREEN))
                                .forEach(p -> System.out.println(" - " + p.name + " is green"));
                pf.filter(products, new SizeSpecification(Size.SMALL))
                                .forEach(p -> System.out.println(" - " + p.name + " is small"));

                System.out.println("Price is 5: (new)");
                pf.filter(products, new PriceSpecification(Price.FIVE))
                                .forEach(p -> System.out.println(" - " + p.name + " is price five"));

                System.out.println("Blue AND Large products: (new)");
                pf.filter(products,
                                new AndSpecification<Product>(new ColorSpecification(Color.BLUE),
                                                new SizeSpecification(Size.LARGE)))
                                .forEach(p -> System.out.println(" - " + p.name + " is blue and large"));

                System.out.println("Green AND Small AND Price five products: (new)");
                pf.filter(products,
                                new AndSpecification<Product>(new ColorSpecification(Color.GREEN),
                                                new SizeSpecification(Size.SMALL), new PriceSpecification(Price.FIVE)))
                                .forEach(p -> System.out.println(" - " + p.name + " is green and small and price five"));
        }
}
