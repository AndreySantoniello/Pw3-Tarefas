package br.com.etechas.tarefas.entities;

import br.com.etechas.tarefas.enums.TarefaStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa", updatable = false)
    private Long id;

    @Column(name = "tx_titulo")
    private String titulo;

    @Column(name = "tx_descricao")
    private String descricao;

    @Column(name = "tx_responsavel")
    private String responsavel;

    @Column(name = "dt_data_limite")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(name = "tx_status")
    private TarefaStatusEnum status;
}
