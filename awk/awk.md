
1. **Input:** AWK takes input from either a file or a data stream. You can pass text data directly to AWK or use it in conjunction with other command-line tools like `cat`, `grep`, or `ls`.

2. **Pattern-Action Structure:** AWK operates on a pattern-action structure. It reads input line by line and compares each line against a set of patterns. If a pattern matches, the associated action is executed.

3. **Fields:** AWK treats each input line as a set of fields. By default, fields are separated by spaces or tabs. You can refer to these fields using `$1`, `$2`, `$3`, and so on, representing the first, second, third fields, and so forth.

4. **Patterns:** Patterns are expressions that determine whether a particular action should be executed for a given line. These patterns can be regular expressions, string matches, or even numerical conditions. For example, `/pattern/` is a pattern that matches lines containing "pattern."

5. **Actions:** Actions are commands that are executed when a corresponding pattern matches a line. Actions can include a wide range of operations, such as printing specific fields, performing calculations, or applying conditional logic.

6. **Built-in Variables:** AWK provides several built-in variables that offer information about the input data and the context in which the program is running. Some commonly used built-in variables are `NF` (number of fields), `NR` (current record number), and `FS` (field separator).

7. **Output:** The default action in AWK is to print the entire input line if no specific action is specified. You can customize the output using the `print` command followed by the fields or values you want to display.

Here's a simple example to illustrate how AWK works:

Suppose you have a file named "data.txt" containing the following lines:

```
Alice 25
Bob 30
Charlie 28
```

You can use AWK to extract and print the names of people who are older than 27:

```bash
awk '$2 > 27 { print $1 }' data.txt
```

In this example:
- `$2` refers to the second field, which is the age.
- The pattern `$2 > 27` matches lines where the age is greater than 27.
- The action `{ print $1 }` prints the first field (names) of the matching lines.

So, the output would be:

```
Bob
Charlie
```

AWK's versatility makes it an essential tool for processing text data in the terminal, especially for tasks like data extraction, report generation, and data transformation.

In AWK, you can print spaces by simply including them within double quotes as part of the `print` statement. For example, to print the text "Hello     World" (with multiple spaces between "Hello" and "World"), you would use:

```bash
awk 'BEGIN { print "Hello     World" }'
```

To print spaces between fields, you can use the space character within the `print` statement, like this:

```bash
awk '{ print $1, $2, $3 }' data.txt
```

In this example, `$1`, `$2`, and `$3` represent the first, second, and third fields respectively, and the spaces between them will be printed as separators.

Regarding the field that represents the last column, AWK provides the built-in variable `NF` (Number of Fields), which gives you the total number of fields on the current line. Therefore, to refer to the last field, you can use `$NF`. This is particularly useful when you don't know in advance how many fields your input data might have.

Here's an example that demonstrates printing the last field of each line:

```bash
awk '{ print $NF }' data.txt
```

If your data is tab-separated, and you want to print the last column while using a custom field separator, you can specify the field separator using the `-F` flag:

```bash
awk -F'\t' '{ print $NF }' tab_separated_data.txt
```

In this example, `\t` represents a tab character, which is the field separator in the "tab_separated_data.txt" file.

### Example
`ls -lah | grep .pdf | awk '{printf("%-60s %-10s\n",  $NF, $5);}'`

## Join multiple csv files

awk '(NR == 1) || (FNR > 1)' *.csv > 1000Plus5years_companies_data.csv

[source link](https://unix.stackexchange.com/questions/293775/merging-contents-of-multiple-csv-files-into-single-csv-file)
