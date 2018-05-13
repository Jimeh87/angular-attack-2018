package io.angularattack.loweredexpectations.rankit;

import io.angularattack.loweredexpectations.rankit.entities.RankedGroup;
import io.angularattack.loweredexpectations.rankit.entities.RankedItem;
import io.angularattack.loweredexpectations.rankit.repositories.RankedGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class RankItApplication {

    @Autowired
    private RankedGroupRepository rankedGroupRepository;

    public static void main(String[] args) {
        SpringApplication.run(RankItApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        printIt(rankedGroupRepository.save(new RankedGroup()
                .setName("Favorite Chili")
                .setShortCode("HYZ456")
                .addAllRankedItems(new RankedItem()
                                .setName("Jim's 5 alarm chili").setScore(1500),
                        new RankedItem()
                                .setName("Dalin's tomato sauce he calls chili").setScore(1500),
                        new RankedItem()
                                .setName("Marc's second place chili").setScore(1500),
                        new RankedItem()
                                .setName("Peng's says he is chili but I think he is just cold").setScore(1500))
        ));

        printIt(rankedGroupRepository.save(new RankedGroup()
                .setName("Coolest guy on the team")
                .setShortCode("ABC123")
                .addAllRankedItems(new RankedItem()
                                .setName("Jim").setScore(1500),
                        new RankedItem()
                                .setName("Dalin").setScore(1500),
                        new RankedItem()
                                .setName("Marc").setScore(1500),
                        new RankedItem()
                                .setName("Peng").setScore(1500))
        ));
    }

    private static void printIt(RankedGroup rankedGroup) {
        System.err.println("Group generated [" + rankedGroup.getId() + "]");
    }

}