from utils.utils import get_input, \
    is_empty_string, get_int, get_trimmed_input, \
    sort_string_by_length
from typing import List

def get_acronym(text: str) -> str:
    chars = list()
    for part in text.split():
        if part[0].isupper():
            chars.append(part[0])
    return "".join(chars)
    
    

def get_sorted_acronyms(texts: List[str]) -> List[str]:
    acronyms = list()
    for text in texts:
        acronym = get_acronym(text)
        if not is_empty_string(acronym):
            acronyms.append(acronym)
    return sort_string_by_length(acronyms)



def get_unempty_inputs(num_inputs: int) -> List[str]:
    texts = list()
    for i in range(num_inputs):
        text = get_trimmed_input(f"Enter input no. {i+1} ")
        if not is_empty_string(text):
            texts.append(text)
    return texts


def main():
    try:
        num_inputs = get_int("Enter number of inputs: ")
        texts = get_unempty_inputs(num_inputs)
        print(get_sorted_acronyms(texts))
    except Exception as e:
        print(str(e))
main()