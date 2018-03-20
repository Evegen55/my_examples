package annotations;

public class AnnotatedClass {

	private int ex;

	public AnnotatedClass() {
	}

	/**
	 * @param ex
	 */
	@ClassPreamble(author = "Me", date = 0)
	public AnnotatedClass(int ex) {
		this.ex = ex;
	}

}
