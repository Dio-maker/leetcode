package exercise.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * date: 2024/5/8
 *
 * @author wmk
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class CalUnitDto {

    private BigDecimal value;
    private String unitCode;
    public CalUnitDto() {
    }

    public CalUnitDto(BigDecimal value, String unitCode) {
        this.value = value;
        this.unitCode=unitCode;
    }

    public CalUnitDto(BigDecimal value) {
        this.value = value;
    }
}