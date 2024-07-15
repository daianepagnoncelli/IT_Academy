package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private LocalDateTime registrationDate;
    private double successRate;
}
