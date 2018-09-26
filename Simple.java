/** Class 390T,
 * using I6 as the base for this API
 *
 */

public class Simple {
  
  private String text;
  private Number number;  
  private Boolean truth;
  private Integer[] initVals;
  private int depth;
  private Integer[] lastVals;
  private int sequenceCalls;

  /**
   *Constructs a Simple object using arbitrary values.
   */
  public Simple() {
    text = "text";
    number = 0;
    truth = true;
    initVals = new Integer[]{1, 1, 2};
    depth = 2;
    lastVals = new Integer[depth]; 
    
    for(int i = 0; i < depth; i++) {
      lastVals[i] = initVals[initVals.length - depth + i];
    }
  }

  /**
   * Constructs a Simple object initialized
   * to the specified values and sequence definition.
   * @param text
   * @param number
   * @param truth
   * @param initVals
   * @param depth
   */
  public Simple( String text, 
                 Number number,
                 Boolean truth,
                 Integer[] initVals,
                 int depth ) {
    this.text = text;
		this.number = number;
		this.truth = truth;
		this.initVals = initVals;
		this.depth = depth;
    lastVals = new Integer[depth];
    
    for(int i = 0; i < depth; i++) {
      lastVals[i] = initVals[initVals.length - depth + i];
    }
  }

  /**
   * Accesses the logical component of state.
   * @return truth
   */
  public Boolean truth() {
    return truth;
  }

  /**
   * Accesses the numerical component of state.
   * @return number
   */
  public Number number() {
    return number;
  }

  /**
   * Accesses the textual component of state.
   * @return text
   */
  public String text() {
    return text;
  }

  /**
   * Modifies the state by inverting the logical value.
   */
  public void flip() {
    truth = !truth;
  }

  /**
   * Accesses items of the sequence, in order, 
   * beginning with the initial values passed into the constructor.
   * If the value of the array is null it is expected that a value of acceptable type will be returned.
   * @return num
   *
   */
  public Integer nextInSequence() {
    Integer num = 0;
    
    if(sequenceCalls + 1 <= initVals.length) {
      num = initVals[sequenceCalls];
    } else {
        for(int i = 0; i < depth; i++) {
        num += lastVals[i];
        if(i + 1 >= depth) {
          lastVals[i] = num;
        } else {
          lastVals[i] = lastVals[i + 1];
        }
      }
    }
    
    sequenceCalls++;
    return num;
  }

  /**
   * Renders Simple object in the format: Simple[truth, number, "text"]
   * @return stringOutput
   */
  public String toString() {
    String stringOutput = "Simple[" + truth + ", " + number + ", " + "\"" + text + "\"" + "]";
    return stringOutput;
  } 

}
