package org.actnext.nlg;
import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class AppParagraph {
	public static void main( String[] args ) {

		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);

		SPhraseSpec p1 = nlgFactory.createClause("Mary", "chase", "the monkey");
		SPhraseSpec p2 = nlgFactory.createClause("The monkey", "fight back");
		SPhraseSpec p3 = nlgFactory.createClause("Mary", "be", "nervous");

		DocumentElement s1 = nlgFactory.createSentence(p1);
		DocumentElement s2 = nlgFactory.createSentence(p2);
		DocumentElement s3 = nlgFactory.createSentence(p3);

		DocumentElement par1 = nlgFactory.createParagraph(Arrays.asList(s1, s2, s3));
		String output = realiser.realise(par1).getRealisation();
		System.out.println(output);
	}
}
