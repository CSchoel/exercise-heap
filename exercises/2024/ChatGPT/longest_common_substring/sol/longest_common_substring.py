def longest_common_substring(str1: str, str2: str) -> str:
    if not str1 or not str2:
        return ""
    
    len1 = len(str1)
    len2 = len(str2)
    
    # Create a table to store lengths of longest common suffixes of
    # substrings. Initialize all values to 0.
    lcs_table = [[0] * (len2 + 1) for _ in range(len1 + 1)]
    
    # To store the length of the longest common substring
    longest_length = 0
    
    # To store the index of the rightmost character of the longest common substring
    result_index = 0
    
    # Fill the lcs_table in a bottom-up manner
    for i in range(1, len1 + 1):
        for j in range(1, len2 + 1):
            if str1[i - 1] == str2[j - 1]:
                lcs_table[i][j] = lcs_table[i - 1][j - 1] + 1
                if lcs_table[i][j] > longest_length:
                    longest_length = lcs_table[i][j]
                    result_index = i
            else:
                lcs_table[i][j] = 0
    
    return str1[result_index - longest_length: result_index]
