import model.Curso;

import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDAO implements ICursoDAO {
    private List<Curso> cursos = new ArrayList<>();

    @Override
    public void create(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void update(Curso curso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigo().equals(curso.getCodigo())) {
                cursos.set(i, curso);
                return;
            }
        }
    }

    @Override
    public void delete(Long codigo) {
        cursos.removeIf(curso -> curso.getCodigo().equals(codigo));
    }

    @Override
    public List<Curso> findAll() {
        return new ArrayList<>(cursos);
    }

    @Override
    public Curso findById(Long codigo) {
        return cursos.stream().filter(curso -> curso.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    @Override
    public List<Curso> findByArea(Curso.Area area) {
        List<Curso> result = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getArea().equals(area)) {
                result.add(curso);
            }
        }
        return result;
    }

    @Override
    public Curso findBySigla(String sigla) {
        return cursos.stream().filter(curso -> curso.getSigla().equalsIgnoreCase(sigla)).findFirst().orElse(null);
    }
}
