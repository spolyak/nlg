package org.actnext.nlg;
import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;
/**
 * Hello world!
 *
 */
public class App2 {
	public static void main( String[] args ) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);
		
		SPhraseSpec s1 = nlgFactory.createClause();
		s1.addPreModifier("Over the duration");
		NPPhraseSpec what = nlgFactory.createNounPhrase("twenty-two season illustrious career");
    	what.setDeterminer("his");
    	PPPhraseSpec pp = nlgFactory.createPrepositionPhrase();
    	pp.addComplement(what);
    	pp.setPreposition("of");
    	s1.addComplement(pp);

		SPhraseSpec s2 = nlgFactory.createClause();
		NPPhraseSpec subject = nlgFactory.createNounPhrase("Babe Ruth");
		subject.addPreModifier("professional baseball player");
		s2.setSubject(subject);
		s2.setVerb("achieve");
		NPPhraseSpec object = nlgFactory.createNounPhrase("right");
		object.addPreModifier("a well-deserved");
		s2.setObject(object);
		s2.addComplement("to be named the greatest of all time");
		s2.setFeature(Feature.TENSE, Tense.PAST);

		CoordinatedPhraseElement c = nlgFactory.createCoordinatedPhrase();
        c.addCoordinate(s1);
        c.addCoordinate(s2);
        c.setConjunction(",");

		String output2 = realiser.realiseSentence(c);
		System.out.println(output2);

	}
}