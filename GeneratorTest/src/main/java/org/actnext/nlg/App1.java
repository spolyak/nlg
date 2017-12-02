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
public class App1 {
	public static void main( String[] args ) {
		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);
		
		SPhraseSpec s1 = nlgFactory.createClause();
		s1.addPreModifier("Near the end");
		NPPhraseSpec what = nlgFactory.createNounPhrase("eight years as a recording session musician");
    	what.setDeterminer("his");
    	PPPhraseSpec pp = nlgFactory.createPrepositionPhrase();
    	pp.addComplement(what);
    	pp.setPreposition("of");
    	s1.addComplement(pp);

		SPhraseSpec s2 = nlgFactory.createClause();
		NPPhraseSpec subject = nlgFactory.createNounPhrase("Leon \"Chu\" Berry");
		subject.addPreModifier("tenor saxophonist");
		s2.setSubject(subject);
		s2.setVerb("land");
		NPPhraseSpec object = nlgFactory.createNounPhrase("spot");
		object.addPreModifier("a short-lived");
		s2.setObject(object);
		s2.addComplement("with Count Basie's orchestra");
		s2.setFeature(Feature.TENSE, Tense.PAST);

		CoordinatedPhraseElement c = nlgFactory.createCoordinatedPhrase();
        c.addCoordinate(s1);
        c.addCoordinate(s2);
        c.setConjunction(",");

		String output2 = realiser.realiseSentence(c);
		System.out.println(output2);

	}
}

