package test;

import static org.junit.Assert.*;

import business.Werbung21;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import business.Kredit;


@RunWith(Suite.class)
@SuiteClasses({StandortTest.class, KuehlraumTest.class, BurgerTest.class, KreditTest.class, BestellungTest.class, LieferantTest.class, CateringTest.class, InnenausstattungTest.class, Werbung21Test.class})
public class BurgerladenTestAll {
	
}
