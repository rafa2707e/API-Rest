package service;

import com.example.demo.model.ExercicioEvolution;
import com.example.demo.repository.ExercicioEvolutionRepository;
import org.springframework.stereotype.Service;
import com.example.demo.model.Exercicio;
import com.example.demo.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    @Autowired
    private ExercicioEvolutionRepository evolutionRepository;

    public List<Exercicio> listarTodos() {
        return repository.findAll();
    }

    public Exercicio salvar(Exercicio exercicio) {
        if (exercicio.getCarga() < 0) {
            throw new RuntimeException("A carga não pode ser negativa!");
        }
        return repository.save(exercicio);
    }

    public void deletExercicio(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Esse exercicio não existe no nosso banco de dados ");
        }
        repository.deleteById(id);
    }

    public Exercicio Search(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercicio não encontrado"));
    }

    public double adicionarCarga(Long id, double ganho) {
        Exercicio exercicioAtual = Search(id);
        double novaCarga = exercicioAtual.getCarga() + ganho;

        double porcentagemEvolucao = calcularPorcentagemEvolucao(id, novaCarga);

        ExercicioEvolution historicoHoje = new ExercicioEvolution();
        historicoHoje.setExercicio(exercicioAtual);
        historicoHoje.setCargaRegistrada(novaCarga);
        evolutionRepository.save(historicoHoje);

        exercicioAtual.setCarga(novaCarga);
        repository.save(exercicioAtual);

        return porcentagemEvolucao;
    }

    public double calcularPorcentagemEvolucao(long id, double cargaNovaInserida) {
        Exercicio exercicio = Search(id);
        Optional<ExercicioEvolution> ultimaEvolucao = evolutionRepository.findFirstByExercicioOrderByDataRegistroDesc(exercicio);

        if (ultimaEvolucao.isEmpty()) {
            System.out.println("É seu primeiro treino, ainda não há evolução.");
            return 0.0;
        } else {
            double cargaAntiga = ultimaEvolucao.get().getCargaRegistrada();
            double evolucao = ((cargaNovaInserida - cargaAntiga) / cargaAntiga) * 100;

            System.out.println("Sua evolução foi de " + evolucao + "%");
            return evolucao;
        }
    }
}