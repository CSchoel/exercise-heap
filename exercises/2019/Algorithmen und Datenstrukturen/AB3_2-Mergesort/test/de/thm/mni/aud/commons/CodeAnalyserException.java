package de.thm.mni.aud.commons;

class CodeAnalyserException extends AssertionError {
  CodeAnalyserException(String result) {
    super(result);
  }
}
