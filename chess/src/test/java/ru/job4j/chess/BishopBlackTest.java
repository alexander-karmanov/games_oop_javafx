package ru.job4j.chess;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {
    @Test
    public void whenPosition() {
        BishopBlack bp = new BishopBlack(Cell.C8);
        Cell pos = bp.position();
        Cell expected = Cell.C8;
        MatcherAssert.assertThat(pos, is(expected));
    }

    @Test
    public void whenCopy() {
        BishopBlack bp = new BishopBlack(Cell.E6);
        Cell dest = bp.copy(Cell.F5).position();
        Cell expected = Cell.F5;
        MatcherAssert.assertThat(dest, is(expected));
    }

    @Test
    public void whenWayRight() {
        BishopBlack bp = new BishopBlack(Cell.E6);
        Cell[] result = bp.way(Cell.G4);
        Cell[] expected = {Cell.F5, Cell.G4};
        MatcherAssert.assertThat(result, is(expected));
   }

    @Test
    public void whenWayWrong() throws ImpossibleMoveException {
        BishopBlack bp = new BishopBlack(Cell.E6);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bp.way(Cell.H4);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from E6 to H4");
        }
}
