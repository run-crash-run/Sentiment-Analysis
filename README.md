Forked from: https://github.com/Ruthwik/Sentiment-Analysis

## How to build this project
1. Download the language model file from: https://stanfordnlp.github.io/CoreNLP/download.html
(eg direct link for English: http://nlp.stanford.edu/software/stanford-corenlp-4.1.0-models-english.jar)
2. Download the project and import the .pom file
3. Run the MainApp.java file, which will call the demo funtion

## Code Explained
### Initialize

```Java
 // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and sentiment
props = new Properties();
props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
StanfordCoreNLP pipeline; = new StanfordCoreNLP(props);
```


### How to find the sentiment score
Run the Annotators on the text and then get the SentimentAnnotatedTree
```Java
// this is the parse tree of the current sentence
Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);

//print the sentiment score using RNNCoreAnnotations
System.out.println("Sentiment Score: " + RNNCoreAnnotations.getPredictedClass(tree));
```

### How to find 5 classes of sentiment classification: very negative, negative, neutral, positive, and very positive.
```Java
// this matrix contains the confidences
SimpleMatrix sm = RNNCoreAnnotations.getPredictedClass(tree);
```
The estimated probability/confidence looks something like this from 'sm' object
```
Type = dense , numRows = 5 , numCols = 1
 0.111  
 0.758  
 0.087  
 0.035  
 0.009
```

### Output
This project has the following output
```
Sentiment Score: 1.0%
Sentiment Type: Negative%
Very positive: 2.0%
Positive: 12.0%
Neutral: 25.0%
Negative: 52.0%
Very negative: 10.0%
```

