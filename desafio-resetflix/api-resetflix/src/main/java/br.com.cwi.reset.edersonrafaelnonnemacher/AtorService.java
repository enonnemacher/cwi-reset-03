package br.com.cwi.reset.edersonrafaelnonnemacher;

// AtorService é onde você vai definir as regras de negócio, as validações e limitações na hora de manipular os atores.

import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) {
    }

}
