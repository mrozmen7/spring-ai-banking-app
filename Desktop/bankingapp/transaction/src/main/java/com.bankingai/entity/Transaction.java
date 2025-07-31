package entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId; // Hangi hesaptan işlem yapılıyor

    private BigDecimal amount; // Yatırılan veya çekilen tutar

    private String type; // deposit / withdraw / transfer

    private LocalDateTime timestamp; // İşlemin yapıldığı tarih-saat

    private String description; // Açıklama, örneğin "ATM'den çekildi"
}