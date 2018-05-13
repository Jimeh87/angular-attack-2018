package io.angularattack.loweredexpectations.rankit;

import io.angularattack.loweredexpectations.rankit.entities.RankedGroup;
import io.angularattack.loweredexpectations.rankit.entities.RankedItem;
import io.angularattack.loweredexpectations.rankit.repositories.RankedGroupRepository;
import io.angularattack.loweredexpectations.rankit.services.RankedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

import static io.angularattack.loweredexpectations.rankit.services.RankedGroupService.START_SCORE;

@EnableJpaAuditing
@SpringBootApplication
public class RankItApplication {

    @Autowired
    private RankedGroupRepository rankedGroupRepository;

    public static void main(String[] args) {
        SpringApplication.run(RankItApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
//        printIt(rankedGroupRepository.save(new RankedGroup()
//                .setName("Favorite Chili")
//                .setShortCode(RankedGroupService.generateShortCode())
//                .addAllRankedItems(new RankedItem()
//                                .setName("Jim's 5 alarm chili")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Dalin's tomato sauce he calls chili")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Marc's second place chili")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Peng says he is chili")
//                                .setScore(START_SCORE))
//        ));
//
//        printIt(rankedGroupRepository.save(new RankedGroup()
//                .setName("Coolest guy on the team")
//                .setShortCode(RankedGroupService.generateShortCode())
//                .addAllRankedItems(new RankedItem()
//                                .setName("Jim")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Dalin")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Marc")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Peng")
//                                .setScore(START_SCORE))
//        ));
//
//        printIt(rankedGroupRepository.save(new RankedGroup()
//                .setName("Favorite Color")
//                .setShortCode(RankedGroupService.generateShortCode())
//                .addAllRankedItems(new RankedItem()
//                                .setName("Blue")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Red")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Green")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Yellow")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Pink")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Orange")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Grey")
//                                .setScore(START_SCORE),
//                        new RankedItem()
//                                .setName("Brown")
//                                .setScore(START_SCORE))
//        ));
    }

    private static void printIt(RankedGroup rankedGroup) {
        System.err.println("Group generated [" + rankedGroup.getId() + "]");
    }

}