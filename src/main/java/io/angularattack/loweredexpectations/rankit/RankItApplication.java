package io.angularattack.loweredexpectations.rankit;

import io.angularattack.loweredexpectations.rankit.entities.RankedGroup;
import io.angularattack.loweredexpectations.rankit.entities.RankedItem;
import io.angularattack.loweredexpectations.rankit.repositories.RankedGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static io.angularattack.loweredexpectations.rankit.services.RankedGroupService.START_SCORE;

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
                                .setName("Jim's 5 alarm chili")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Dalin's tomato sauce he calls chili")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Marc's second place chili")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Peng says he is chili")
                                .setScore(START_SCORE))
        ));

        printIt(rankedGroupRepository.save(new RankedGroup()
                .setName("Coolest guy on the team")
                .setShortCode("ABC123")
                .addAllRankedItems(new RankedItem()
                                .setName("Jim")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Dalin")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Marc")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Peng")
                                .setScore(START_SCORE))
        ));

        printIt(rankedGroupRepository.save(new RankedGroup()
                .setName("Favorite Color")
                .setShortCode("ABC12Z")
                .addAllRankedItems(new RankedItem()
                                .setName("Blue")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Red")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Green")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Yellow")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Pink")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Orange")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Grey")
                                .setScore(START_SCORE),
                        new RankedItem()
                                .setName("Brown")
                                .setScore(START_SCORE))
        ));
    }

    private static void printIt(RankedGroup rankedGroup) {
        System.err.println("Group generated [" + rankedGroup.getId() + "]");
    }

}