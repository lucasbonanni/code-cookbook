# Pytest recipes

## How to test any API using python.

## Required modules
- `pip install requests`
- `pip install pytest`

```python
import request
import pytest

user_data = [
    (1,"Luke Skywalker"),
    (2, "C-3PO"),
    (3, "R2-D2"),
]

@pytest.mark.parametrize('id, expected_name', user_data)
def test_user_names(user_id, expected_name):
    url = f'https://swapi.dev/api/people/{id}'
    response = requests.get(url)
    people = response.json()

    assert people['name'] == expected_name

```