package my.kukish.treny.dto;

import lombok.Value;

@Value
public class TrainingWeekCreateEditDto {
    int weekNum;
    String repetitions;
    Integer numberOfApproaches;
    String name;
    String day;
}
