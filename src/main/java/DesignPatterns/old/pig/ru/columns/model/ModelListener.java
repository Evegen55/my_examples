package DesignPatterns.old.pig.ru.columns.model;

public interface ModelListener {

	void gotTriple(int a, int b, int c, int d, int i, int j);
	
	void changed(Model model);

}
