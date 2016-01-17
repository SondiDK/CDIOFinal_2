package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDice.class, TestPiece.class, TestPlayer.class, TestStart.class })
public class AllTests {

}
