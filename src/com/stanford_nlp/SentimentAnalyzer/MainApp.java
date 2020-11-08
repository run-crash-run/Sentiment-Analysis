package com.stanford_nlp.SentimentAnalyzer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.stanford_nlp.model.SentimentResult;

public class MainApp {

	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<String>();
		// original string from forked project
		list.add("Those who find ugly meanings in beautiful things are corrupt without being charming.");

		// positive sentiment
		list.add("Everyday In Every Way I’m Getting Better And Better");

		// non English words (neutral sentiment)
		list.add("an bhfuil cead agam dul go dti an leithreas");

		// negative sentiment (Metallica - fade to balck lyrics)
		list.add("Everyday In Every Way I’m Getting worse and worse");
	}

	public static void demo(List<String> list){
		final String SEPERATOR = "=================================================";

		for(String input : list) {
			SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
			sentimentAnalyzer.initialize();
			SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(input);

			System.out.println(SEPERATOR);
			System.out.println("Input string: " + input);
			System.out.println(SEPERATOR);
			System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
			System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
			System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive() + "%");
			System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive() + "%");
			System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral() + "%");
			System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative() + "%");
			System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative() + "%");
			System.out.println(SEPERATOR);
		}
	}
}
