package sort.util;

/**
 * This class is used a a representative of the <code>Object</code> class for
 * testing purposes. By declaring attributes as built-ins and
 * <code>String</code> values, we try to perform ligthweight instances and fast
 * comparisons against them. <br>
 * The heart of the matter is that this class implements the
 * <code>Comparable</code> interface, which is mandatory for using the sorting
 * algorithms.
 */
public final class ExamResult implements Comparable<ExamResult>, Cloneable {

	private final Double grade;
	private final String studentName;
	private final boolean withHonors;

	public ExamResult(final double grade, final String studentName,
			final boolean withHonors) {
		this.grade = grade;
		this.studentName = studentName;
		this.withHonors = withHonors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(grade);
		result = (prime * result) + (int) (temp ^ (temp >>> 32));
		result = (prime * result)
				+ ((studentName == null) ? 0 : studentName.hashCode());
		result = (prime * result) + (withHonors ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ExamResult))
			return false;
		final ExamResult other = (ExamResult) obj;
		if (Double.doubleToLongBits(grade) != Double
				.doubleToLongBits(other.grade))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (withHonors != other.withHonors)
			return false;
		return true;
	}

	@Override
	public int compareTo(final ExamResult o) {
		if (grade.compareTo(o.grade) > 0)
			return 1;
		else if ((grade.compareTo(o.grade) < 0))
			return -1;
		else if (withHonors && !o.withHonors)
			return 1;
		else if (withHonors && o.withHonors)
			return studentName.compareTo(o.studentName);
		else if (!withHonors && !o.withHonors)
			return studentName.compareTo(o.studentName);
		else
			return -1;
	}

	@Override
	public ExamResult clone() {
		return new ExamResult(grade, studentName, withHonors);
	}

	@Override
	public String toString() {
		return "ExamResult [grade=" + grade + ", studentName=" + studentName
				+ ", withHonors=" + withHonors + "]";
	}
}
