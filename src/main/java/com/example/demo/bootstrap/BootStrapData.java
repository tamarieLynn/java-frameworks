package com.example.demo.bootstrap;

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


        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("VVNAZ Martial Arts");
        o.setName("Belts");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        OutsourcedPart o2= new OutsourcedPart();
        o2.setName("Tops");
        o2.setInv(5);
        o2.setPrice(20.0);
        o2.setId(101L);
        OutsourcedPart o3= new OutsourcedPart();
        o3.setName("Pants");
        o3.setInv(5);
        o3.setPrice(20.0);
        o3.setId(102L);
        OutsourcedPart o4= new OutsourcedPart();
        o4.setName("Helmets");
        o4.setInv(5);
        o4.setPrice(20.0);
        o4.setId(103L);
        OutsourcedPart o5= new OutsourcedPart();
        o5.setName("Chest Gear");
        o5.setInv(5);
        o5.setPrice(20.0);
        o5.setId(104L);

 // save only when outsourced part == 0

        outsourcedPartRepository.save(o);
        outsourcedPartRepository.save(o2);
        outsourcedPartRepository.save(o3);
        outsourcedPartRepository.save(o4);
        outsourcedPartRepository.save(o5);

        OutsourcedPart thePart = null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (int i = 0; i < outsourcedParts.size(); i++) {
            OutsourcedPart part = outsourcedParts.get(i);
            if (part.getName().equals("Belts")) thePart = part;
        }

        System.out.println(thePart.getCompanyName());

        //List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        Product uniforms = new Product("Uniform", 50.0, 20);
        Product fightingGear = new Product("Fighting Gear", 50.0, 20);
        Product weapons = new Product("weapons", 20.0, 20);
        Product awards = new Product("Awards", 5.0, 100);
        Product firstAide = new Product("First Aide", 20.0, 50);

        if (!productRepository.findByName("Uniform")) {
            productRepository.save(uniforms);
        }
        if (!productRepository.findByName("Fighting Gear")) {
            productRepository.save(fightingGear);
        }
        if (!productRepository.findByName("Weapons")) {
            productRepository.save(weapons);
        }
        if (!productRepository.findByName("Awards")){
            productRepository.save(awards);
        }
        if (!productRepository.findByName("First Aide")) {
            productRepository.save(firstAide);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
