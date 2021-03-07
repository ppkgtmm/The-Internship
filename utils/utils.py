from typing import List

def get_input(message: str) -> str: 
    inp = input(message)
    return inp

def is_empty_string(string: str) -> bool:
    return len(string.strip()) == 0

def get_trimmed_input(message: str) -> str: 
    inp = get_input(message)
    return inp.strip()

def get_int(message: str):
    inp = get_trimmed_input(message)
    try:
        return int(inp)
    except Exception:
        raise Exception("unable to convert input to integer")

def sort_string_by_length(texts: List[str]):
    return sorted(texts, key=lambda x: len(x), reverse=True)