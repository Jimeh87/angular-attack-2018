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
                .addAllRankedItems(new RankedItem()
                                .setName("Jim's 5 alarm chili"),
                        new RankedItem()
                                .setName("Dalin's tomato sauce he calls chili"),
                        new RankedItem()
                                .setName("Marc's second place chili"),
                        new RankedItem()
                                .setName("Peng's says he is chili but I think he is just cold"))
        ));

        printIt(rankedGroupRepository.save(new RankedGroup()
                .setName("Coolest guy on the team")
                .addAllRankedItems(new RankedItem()
                                .setName("Jim"),
                        new RankedItem()
                                .setName("Dalin"),
                        new RankedItem()
                                .setName("Marc"),
                        new RankedItem()
                                .setName("Peng"))
        ));
    }

    private static void printIt(RankedGroup rankedGroup) {
        System.err.println("Group generated [" + rankedGroup.getId() + "]");
    }

}