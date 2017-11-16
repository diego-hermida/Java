package adt.heaps;

/**
 * Class for heap elements.<br>
 * <p>
 * A heap element contains two attributes: a key which will be used to build the
 * tree (int or double, either primitive type or object) and any kind of
 * IMMUTABLE object the user sees fit to carry any information he/she likes. Be
 * aware that the use of a mutable object might jeopardize the integrity of this
 * information.
 * </p>
 *
 * @author Nicolas Renard
 *
 */
public class HeapElement {
	private final double key;
	private final Object additionalInfo;

	// Constructors

	/**
	 *
	 * @param key
	 *            : a number of primitive type 'double'
	 * @param info
	 *            : any kind of IMMUTABLE object. May be null, since the purpose
	 *            is only to carry additional information of use for the user
	 */
	public HeapElement(final double key, final Object info) {
		this.key = key;
		additionalInfo = info;
	}

	/**
	 *
	 * @param key
	 *            : a number of primitive type 'int'
	 * @param info
	 *            : any kind of IMMUTABLE object. May be null, since the purpose
	 *            is only to carry additional information of use for the user
	 */
	public HeapElement(final int key, final Object info) {
		this.key = key;
		additionalInfo = info;
	}

	/**
	 *
	 * @param key
	 *            : a number of object type 'Integer'
	 * @param info
	 *            : any kind of IMMUTABLE object. May be null, since the purpose
	 *            is only to carry additional information of use for the user
	 */
	public HeapElement(final Integer key, final Object info) {
		this.key = key;
		additionalInfo = info;
	}

	/**
	 *
	 * @param key
	 *            : a number of object type 'Double'
	 * @param info
	 *            : any kind of IMMUTABLE object. May be null, since the purpose
	 *            is only to carry additional information of use for the user
	 */
	public HeapElement(final Double key, final Object info) {
		this.key = key;
		additionalInfo = info;
	}

	/**
	 *
	 * @param key
	 *            : a number of primitive type 'double'
	 */
	public HeapElement(final double key) {
		this.key = key;
		additionalInfo = null;
	}

	/**
	 *
	 * @param key
	 *            : a number of primitive type 'int'
	 */
	public HeapElement(final int key) {
		this.key = key;
		additionalInfo = null;
	}

	/**
	 *
	 * @param key
	 *            : a number of object type 'Integer'
	 */
	public HeapElement(final Integer key) {
		this.key = key;
		additionalInfo = null;
	}

	/**
	 *
	 * @param key
	 *            : a number of object type 'Double'
	 */
	public HeapElement(final Double key) {
		this.key = key;
		additionalInfo = null;
	}

	// Getters
	/**
	 * @return the object containing the additional info provided by the user.
	 */
	public Object getInfo() {
		return additionalInfo;
	}

	/**
	 * @return the key value of the element
	 */
	public double getKey() {
		return key;
	}

	// Overridden object methods

	@Override
	public String toString() {
		return "Key: " + key + " - " + additionalInfo.toString();
	}

	/**
	 *
	 * @param otherHeapElement
	 * @return true if the keys on both elements are identical and the
	 *         additional info objects are identical.
	 */
	public boolean equals(final HeapElement otherHeapElement) {
		return (key == otherHeapElement.key)
				&& (additionalInfo.equals(otherHeapElement.additionalInfo));
	}
}
