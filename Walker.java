public class Walker {
  private int company;
  private int capacity;
  private int clockIn;
  private int clockOut;

  public Walker(int company, int capacity, int clockIn, int clockOut) {
    this.company = company;
    this.capacity = capacity;
    this.clockIn = clockIn;
    this.clockOut = clockOut;
  }

  public Walker(String information) {
    int[] info = new int[4];
    int count = 0;
    String something = information;
    int space = something.indexOf(" ");
    while (space > 0) {
      info[count] = Integer.parseInt(something.substring(0, space));
      something = something.substring(space + 1);
      space = something.indexOf(" ");
      count++;
    }
    info[count] = Integer.parseInt(something);
    this.company = info[0];
    this.capacity = info[1];
    this.clockIn = info[2];
    this.clockOut = info[3];
  }

  public String getAttributes() {
    return "Company: " + this.company + "; Can only walk " + this.capacity + " dogs; Works from " + this.clockIn + " to " + this.clockOut + ".";
  }

  public int getCompany() {
    return this.company;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public int getClockIn() {
    return this.clockIn;
  }

  public int getClockOut() {
    return this.clockOut;
  } 
}


       //canner scanner = new Scanner(new File("flips.txt")); // code I wrote by myself
      //  for (int i = 0; i < fileSize; i++) {
      //      String side = scanner.nextLine();
      //      if (side.equals("heads")) {
      //          heads++;
    //     } else if (side.equals("tails")) {
      //          tails++;
      //      }
      //  } 