package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(outsourcedPartRepository.count() == 0) {
            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("HyperGlides");
            o.setName("HyperGlides");
            o.setInv(30);
            o.setPrice(20.0);
            o.setId(100L);
            o.setMaxInv(60);
            o.setMinInv(5);
            outsourcedPartRepository.save(o);

            OutsourcedPart t = new OutsourcedPart();
            t.setCompanyName("Tiger Ice");
            t.setName("Tiger Ice I");
            t.setInv(40);
            t.setPrice(20.0);
            t.setId(200L);
            t.setMaxInv(70);
            t.setMinInv(2);
            outsourcedPartRepository.save(t);

            OutsourcedPart t2 = new OutsourcedPart();
            t2.setCompanyName("Tiger Ice");
            t2.setName("Tiger Ice II");
            t2.setInv(25);
            t2.setPrice(35.0);
            t2.setId(300L);
            t2.setMinInv(2);
            t2.setMaxInv(55);
            outsourcedPartRepository.save(t2);

            InhousePart i = new InhousePart();
            i.setName("MeekFeet");
            i.setInv(60);
            i.setPrice(10.0);
            i.setId(400L);
            i.setMinInv(5);
            i.setMaxInv(100);
            partRepository.save(i);

            InhousePart i2 = new InhousePart();
            i2.setName("MeekFeet II");
            i2.setInv(60);
            i2.setPrice(15.0);
            i2.setId(500L);
            i2.setMinInv(5);
            i2.setMaxInv(90);
            partRepository.save(i2);


        } else{
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        }
        if(productRepository.count() == 0) {
            Product superlight = new Product("SuperLight", 89.99, 25);
            Product finalmouse = new Product("Final Mouse", 179.99, 5);
            Product fk2 = new Product("Zowie Fk2", 69.99, 30);
            Product deathadder = new Product("Death Adder", 129.99, 15);
            Product endgame = new Product("Endgame", 59.99, 40);

            productRepository.save(superlight);
            productRepository.save(finalmouse);
            productRepository.save(fk2);
            productRepository.save(deathadder);
            productRepository.save(endgame);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
