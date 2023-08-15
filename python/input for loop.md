# How to read an input redirection from the terminal and loop through it

We have file with a list for example words

_names.txt_
```csv
luke
chewie
han
```

_main.py_
```python
import sys

for word in sys.stdin:
    print(word)
```

command: `cat names.txt | python3 main.py`