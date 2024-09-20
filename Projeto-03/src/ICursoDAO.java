import java.util.List;
import model.Curso;
import model.Curso;

public interface ICursoDAO {
    void create(Curso curso);
    void update(Curso curso);
    void delete(Long codigo);
    List<Curso> findAll();
    Curso findById(Long codigo);
    List<Curso> findByArea(Curso.Area area);
    Curso findBySigla(String sigla);
}

