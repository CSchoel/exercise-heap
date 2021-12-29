# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.0.4] - 2021-12-29

### Added

* Type aliases for more complex types such as `Index` and `IndexVector`
* Function `explain_similarity`, which returns the terms that had the most weight in calculating cosine similarity.
* Parameter `explain` in `find_similar`, which allows printing explanations for which terms determined the similarity.

### Changed

* Term frequency is now divided by total number of terms in order to make index independent of document length.
* Uses `log ((n+1) / count)` instead of `log ((n+1) / count)` in `idf` to avoid weights becoming zero for terms that appear in each document.
* Index is now a dictionary instead of a list of tuples.
* Use custom tokenization algorithm, which separates by spaces and then trims non-word characters from both ends of the token.
* Only apply stemming to words, which only consist of word characters and `-`.
* Removes keep_default from `dict_reduce` and introduces `dict_filter` instead.

### Fixed

* Applies `make_hashable` to tags to ensure that same tag names are used on both sides of comparison.
* Forgot to apply IDF weights to query vector.

## [0.0.3] - 2021-12-27

### Added

- this changelog
- Python script that can generate recommendations which tags to add or remove from an exercise based on existing exercise tags

### Changed

- Switched to keyword-style tags for all existing exercises.
- Updated import scripts to provide keyword-style tags and add UUIDs.
- Added explanation of UUID use in readme.

## [0.0.2] - 2021-12-21

### Added

- script to add UUID to exercises
- all exercises can now be identified via a UUID
- import script for exercises from "Algorithmen und Datenstrukturen"
- exercise files for Algorithmen und Datenstrukturen 2019
- `requirements.txt` file for scripts

### Changed

- Tag scheme in readme now uses `- category: value` as syntax instead of `- tagname`.

## [0.0.1] - 2021-12-15

### Added

- README
- exercises from "Grundlagen der Informatik (BI Master)"
- import script for dozeloc exercises from "Grundlagen der Informatik (BI Master)"
- first exercises from other courses
  - Brückenkurs 2019
  - Objektorientierte Programmierung 2014
  - Objektorientierte Programmierung (BI Master) 2015
  - Girl's Day 2019 (full)

[Unreleased]: https://github.com/cschoel/exercise-heap/compare/v0.0.4...HEAD
[0.0.4]: https://github.com/cschoel/exercise-heap/compare/v0.0.3...v0.0.4
[0.0.3]: https://github.com/cschoel/exercise-heap/compare/v0.0.2...v0.0.3
[0.0.2]: https://github.com/cschoel/exercise-heap/compare/v0.0.1...v0.0.2
[0.0.1]: https://github.com/cschoel/exercise-heap/releases/tag/v0.0.1
