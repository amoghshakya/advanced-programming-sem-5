# What are the advantages of using PrintWriter rather than using BufferedWriter and FileWriter explain with example.

> Answers Question 3

`PrintWriter`, `BufferedWriter`, and `FileWriter` are all classes used in Java used for writing text to files, but they
have different functionalities and used in different scenarios. Primarily, the main advantage of `PrintWriter` over
other `Writer` classes are the *print* methods the `PrintWriter` class provides.

## Advantages of `PrintWriter`

- `PrintWriter` provides methods like `print()`, `println()`, and `printf()`, which are more convenient and easier to
  use for formatted text output compared to `BufferedWriter` and `FileWriter`.
- `PrintWriter` also has methods like `checkError()` to check if any error occurred while writing. This isn't available
  in `BufferedWriter` and `FileWriter`.
- `PrintWriter` can also wrap other writers like `BufferedWriter` and `FileWriter`, providing flexibility in managing
  the output.

## Example

### Using `FileWriter`

```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("fileWriterExample.txt")) {
            fw.write("Hello, world!");
            fw.write("Example using FileWriter class.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

Using the `FileWriter` class is simple and straightforward. However, it lacks buffering, which can lead to inefficient
I/O operations when writing large amounts of output.

### Using `BufferedWriter`

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedWriterExample.txt"))) {
            bw.write("Hello, World!");
            bw.newLine();
            bw.write("This is an example using BufferedWriter.");
            bw.write(String.format("%s, %s!", "Hello", "world"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

`BufferedWriter` provides buffering, which improves performance over large amount of data. However, it has limited
formatting options. (Although, `String.format()` can be used to format the string.)

### Using `PrintWriter`

```java
import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterExample {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("printWriterExample.txt")) {
            pw.println("Hello, World!");
            pw.println("This is an example using PrintWriter.");
            pw.printf("Formatted number: %.2f", 123.456);

            System.out.println("Has any error occurred? " + pw.checkError());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

`PrintWriter` provides convenient methods to format the output (`print()`, `println()`, `printf()`). This gives the
programmer
more control over the file output. `PrintWriter` can also
automatically flush the buffer. It also provides better error handling with `checkError()` method.