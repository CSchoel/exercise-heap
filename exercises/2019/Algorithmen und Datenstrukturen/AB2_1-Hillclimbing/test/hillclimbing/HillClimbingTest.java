package hillclimbing;

import org.junit.Test;

import static org.junit.Assert.fail;

public class HillClimbingTest {

  private int[][] hill0 = generateHill(25, 17, 0);
  private int[][] hill1 = generateHill(42, 42, 42);

  private int[][] generateHill(int size, double noiseFactor, int offset) {
    int[][] hill = new int[size][size];
    for (int x = 0; x < hill.length; x++) {
      for (int y = 0; y < hill[x].length; y++) {
        double val = ImprovedNoise.noise((x + offset) / noiseFactor, (y + offset) / noiseFactor, 0) * 100;
        hill[x][y] = Math.abs((int) val);
        //System.out.printf("%d,\t", hill[x][y]);
      }
      //System.out.println();
    }
    return hill;
  }


  /** Ein gutes Beispiel für das Testen. Achtung, X und Y Achse sind vertauscht! */
  private int[][] smallHill = {
    {0,1,2,3,4},
    {4,5,5,6,0},
    {4,6,3,2,1},
    {5,6,7,8,9},
    {0,0,0,0,0}
  };

    /* Diese Karte wird oben für hill0 generiert. (X- und Y-Achse vertauscht dargestellt)
    private int[][] hill0 = {
            {0, 0, 1, 3, 6, 10, 15, 19, 23, 26, 27, 26, 24, 21, 16, 11, 5, 0, 6, 12, 20, 28, 35, 42, 47},
            {5, 5, 4, 2, 1, 5, 9, 14, 17, 20, 21, 21, 19, 15, 11, 5, 0, 5, 11, 18, 25, 33, 40, 46, 50},
            {10, 10, 9, 6, 3, 0, 5, 9, 13, 15, 16, 16, 14, 11, 6, 1, 4, 10, 16, 23, 30, 37, 44, 49, 53},
            {13, 13, 12, 10, 6, 2, 2, 6, 10, 12, 13, 13, 11, 7, 3, 1, 7, 13, 19, 26, 32, 39, 46, 51, 54},
            {14, 14, 13, 11, 7, 3, 0, 5, 8, 11, 12, 12, 10, 6, 2, 3, 8, 14, 20, 27, 33, 40, 46, 50, 52},
            {13, 13, 12, 10, 7, 2, 1, 6, 9, 12, 13, 12, 10, 7, 3, 2, 8, 13, 19, 26, 32, 38, 44, 47, 49},
            {11, 11, 10, 7, 4, 0, 4, 8, 12, 14, 15, 15, 13, 10, 5, 0, 5, 11, 17, 23, 29, 35, 40, 43, 44},
            {7, 7, 6, 3, 0, 3, 8, 12, 16, 18, 19, 19, 17, 14, 9, 4, 1, 7, 13, 19, 25, 30, 35, 37, 38},
            {2, 2, 1, 0, 4, 8, 12, 17, 20, 23, 24, 24, 22, 18, 14, 9, 3, 2, 8, 14, 20, 25, 29, 31, 32},
            {2, 2, 3, 5, 9, 13, 18, 22, 26, 28, 29, 29, 27, 24, 19, 14, 8, 2, 3, 9, 14, 19, 23, 25, 25},
            {7, 7, 8, 10, 14, 18, 22, 27, 30, 33, 34, 34, 32, 28, 24, 18, 13, 7, 1, 4, 9, 14, 18, 19, 19},
            {11, 11, 12, 14, 18, 22, 26, 31, 34, 37, 38, 38, 36, 32, 28, 22, 17, 11, 5, 0, 5, 10, 13, 15, 15},
            {13, 14, 15, 17, 20, 24, 29, 33, 37, 39, 41, 40, 38, 35, 30, 25, 19, 13, 7, 2, 3, 7, 10, 12, 12},
            {14, 14, 15, 18, 21, 25, 30, 34, 38, 40, 41, 41, 39, 36, 31, 26, 20, 14, 8, 3, 2, 6, 10, 11, 12},
            {13, 13, 14, 16, 20, 24, 29, 33, 37, 39, 40, 40, 38, 34, 30, 25, 19, 13, 7, 1, 3, 7, 11, 13, 13},
            {10, 10, 11, 13, 17, 21, 25, 30, 33, 36, 37, 37, 35, 31, 27, 22, 16, 10, 4, 1, 6, 11, 14, 16, 16},
            {5, 5, 6, 9, 12, 16, 21, 25, 29, 31, 32, 32, 30, 27, 22, 17, 11, 5, 0, 5, 11, 15, 19, 21, 21},
            {0, 0, 1, 3, 6, 10, 15, 19, 23, 26, 27, 26, 24, 21, 16, 11, 5, 0, 5, 11, 16, 21, 24, 26, 27},
            {6, 5, 4, 2, 0, 4, 9, 13, 17, 20, 21, 20, 18, 15, 10, 5, 0, 5, 11, 17, 22, 27, 30, 32, 33},
            {12, 12, 11, 9, 5, 1, 2, 7, 11, 13, 14, 14, 12, 9, 4, 0, 5, 11, 17, 22, 28, 32, 36, 38, 38},
            {20, 19, 18, 16, 12, 8, 4, 0, 3, 6, 7, 7, 5, 2, 1, 6, 11, 16, 22, 27, 32, 37, 40, 42, 43},
            {28, 27, 26, 23, 20, 15, 11, 7, 3, 0, 0, 0, 1, 3, 7, 11, 16, 21, 26, 31, 35, 40, 43, 46, 47},
            {35, 34, 33, 30, 26, 22, 18, 14, 10, 8, 6, 6, 7, 9, 13, 16, 20, 24, 28, 33, 37, 41, 45, 48, 50},
            {42, 40, 38, 35, 32, 28, 24, 20, 16, 14, 13, 12, 13, 15, 17, 20, 23, 26, 29, 33, 37, 40, 44, 48, 51},
            {47, 45, 42, 39, 35, 32, 28, 24, 21, 19, 18, 18, 18, 19, 21, 23, 25, 27, 29, 31, 34, 38, 42, 45, 49}};
            */
    /*
            0,	2,	4,	7,	9,	11,	13,	16,	18,	19,	21,	23,	24,	25,	26,	26,	27,	27,	27,	26,	25,	25,	23,	22,	21,	19,	17,	15,	13,	12,	10,	8,	6,	5,	4,	2,	1,	1,	0,	0,	0,	0,
            2,	4,	7,	9,	11,	14,	16,	18,	20,	22,	24,	25,	26,	27,	28,	29,	29,	29,	29,	29,	28,	27,	26,	24,	23,	21,	20,	18,	16,	14,	12,	10,	9,	7,	6,	5,	4,	3,	3,	2,	2,	2,
            4,	7,	9,	11,	14,	16,	18,	20,	22,	24,	26,	27,	29,	30,	31,	31,	31,	32,	31,	31,	30,	29,	28,	27,	25,	24,	22,	20,	18,	16,	15,	13,	11,	10,	8,	7,	6,	6,	5,	5,	4,	4,
            7,	9,	11,	14,	16,	18,	20,	23,	25,	26,	28,	30,	31,	32,	33,	33,	34,	34,	34,	33,	33,	32,	31,	29,	28,	26,	24,	23,	21,	19,	17,	16,	14,	12,	11,	10,	9,	8,	8,	7,	7,	7,
            9,	11,	14,	16,	18,	21,	23,	25,	27,	29,	30,	32,	33,	34,	35,	36,	36,	36,	36,	36,	35,	34,	33,	32,	30,	29,	27,	25,	23,	22,	20,	18,	17,	15,	14,	13,	12,	11,	10,	10,	10,	10,
            11,	14,	16,	18,	20,	23,	25,	27,	29,	31,	32,	34,	35,	36,	37,	38,	38,	38,	38,	38,	37,	37,	35,	34,	33,	31,	30,	28,	26,	24,	23,	21,	19,	18,	17,	16,	15,	14,	13,	13,	13,	13,
            13,	16,	18,	20,	22,	25,	27,	29,	31,	33,	34,	36,	37,	38,	39,	40,	40,	41,	41,	40,	40,	39,	38,	37,	35,	34,	32,	31,	29,	27,	26,	24,	22,	21,	20,	19,	18,	17,	16,	16,	16,	16,
            16,	18,	20,	22,	24,	27,	29,	31,	33,	34,	36,	38,	39,	40,	41,	42,	42,	43,	43,	42,	42,	41,	40,	39,	38,	37,	35,	33,	32,	30,	29,	27,	25,	24,	23,	22,	21,	20,	19,	19,	19,	19,
            18,	20,	22,	24,	26,	28,	30,	32,	34,	36,	38,	39,	41,	42,	43,	44,	44,	44,	44,	44,	44,	43,	43,	42,	40,	39,	38,	36,	35,	33,	32,	30,	29,	27,	26,	25,	24,	23,	23,	22,	22,	22,
            19,	21,	24,	26,	28,	30,	32,	34,	36,	37,	39,	41,	42,	43,	44,	45,	46,	46,	46,	46,	46,	45,	45,	44,	43,	42,	40,	39,	38,	36,	35,	33,	32,	31,	29,	28,	27,	27,	26,	26,	25,	25,
            21,	23,	25,	27,	29,	31,	33,	35,	37,	38,	40,	42,	43,	44,	45,	46,	47,	47,	48,	48,	48,	47,	47,	46,	45,	44,	43,	42,	40,	39,	38,	36,	35,	34,	33,	32,	31,	30,	29,	29,	29,	28,
            23,	24,	26,	28,	30,	32,	34,	36,	37,	39,	41,	42,	44,	45,	46,	47,	48,	49,	49,	49,	49,	49,	49,	48,	47,	46,	45,	44,	43,	42,	41,	40,	38,	37,	36,	35,	34,	33,	33,	32,	32,	32,
            24,	26,	27,	29,	31,	33,	34,	36,	38,	40,	41,	43,	44,	46,	47,	48,	49,	50,	50,	50,	51,	50,	50,	50,	49,	49,	48,	47,	46,	45,	44,	43,	41,	40,	39,	38,	37,	37,	36,	35,	35,	35,
            25,	27,	28,	30,	31,	33,	35,	36,	38,	40,	41,	43,	44,	46,	47,	48,	49,	50,	51,	51,	52,	52,	52,	51,	51,	51,	50,	49,	48,	47,	46,	45,	44,	43,	42,	41,	41,	40,	39,	39,	38,	38,
            26,	27,	29,	30,	32,	33,	35,	36,	38,	40,	41,	43,	44,	46,	47,	48,	49,	50,	51,	52,	52,	53,	53,	53,	53,	52,	52,	51,	51,	50,	49,	48,	47,	46,	45,	44,	44,	43,	42,	41,	41,	40,
            26,	28,	29,	30,	31,	33,	34,	36,	37,	39,	41,	42,	44,	45,	47,	48,	49,	50,	51,	52,	53,	53,	54,	54,	54,	54,	53,	53,	53,	52,	51,	50,	50,	49,	48,	47,	46,	46,	45,	44,	43,	43,
            27,	28,	29,	30,	31,	32,	34,	35,	37,	38,	40,	41,	43,	44,	46,	47,	49,	50,	51,	52,	53,	53,	54,	54,	55,	55,	55,	55,	54,	54,	53,	53,	52,	51,	50,	50,	49,	48,	47,	46,	46,	45,
            27,	28,	29,	29,	30,	32,	33,	34,	35,	37,	38,	40,	41,	43,	45,	46,	48,	49,	50,	51,	52,	53,	54,	55,	55,	56,	56,	56,	56,	55,	55,	54,	54,	53,	53,	52,	51,	50,	49,	49,	48,	47,
            27,	27,	28,	29,	29,	30,	32,	33,	34,	35,	37,	38,	40,	41,	43,	45,	46,	48,	49,	51,	52,	53,	54,	55,	55,	56,	56,	57,	57,	57,	56,	56,	55,	55,	54,	54,	53,	52,	51,	50,	49,	48,
            26,	27,	27,	28,	28,	29,	30,	31,	32,	33,	35,	36,	38,	40,	41,	43,	45,	46,	48,	49,	51,	52,	53,	54,	55,	56,	57,	57,	57,	57,	57,	57,	57,	56,	56,	55,	54,	53,	52,	52,	51,	50,
            25,	26,	26,	26,	27,	27,	28,	29,	30,	31,	33,	34,	36,	37,	39,	41,	43,	44,	46,	48,	49,	51,	52,	54,	55,	56,	56,	57,	58,	58,	58,	58,	58,	57,	57,	56,	55,	54,	53,	52,	51,	50,
            25,	25,	25,	25,	25,	25,	26,	27,	28,	29,	30,	32,	33,	35,	37,	39,	40,	42,	44,	46,	48,	50,	51,	53,	54,	55,	56,	57,	57,	58,	58,	58,	58,	58,	57,	57,	56,	55,	54,	53,	52,	51,
            23,	23,	23,	23,	23,	23,	24,	24,	25,	26,	28,	29,	31,	32,	34,	36,	38,	40,	42,	44,	46,	48,	49,	51,	53,	54,	55,	56,	57,	58,	58,	58,	58,	58,	57,	57,	56,	55,	54,	53,	52,	51,
            22,	22,	21,	21,	21,	21,	21,	22,	23,	24,	25,	26,	28,	29,	31,	33,	35,	37,	39,	42,	44,	46,	48,	49,	51,	53,	54,	55,	56,	57,	57,	58,	58,	58,	57,	57,	56,	55,	54,	53,	51,	50,
            21,	20,	19,	19,	19,	19,	19,	19,	20,	21,	22,	23,	25,	26,	28,	30,	32,	34,	37,	39,	41,	43,	45,	47,	49,	51,	52,	54,	55,	56,	56,	57,	57,	57,	57,	56,	55,	54,	53,	52,	51,	49,
            19,	18,	17,	17,	16,	16,	16,	16,	17,	18,	19,	20,	21,	23,	25,	27,	29,	31,	34,	36,	38,	41,	43,	45,	47,	49,	51,	52,	53,	54,	55,	56,	56,	56,	56,	55,	54,	53,	52,	51,	49,	48,
            17,	16,	15,	14,	14,	13,	13,	13,	14,	14,	15,	17,	18,	20,	22,	24,	26,	28,	31,	33,	35,	38,	40,	43,	45,	47,	49,	50,	51,	53,	53,	54,	54,	54,	54,	54,	53,	52,	51,	49,	48,	46,
            15,	14,	13,	12,	11,	11,	10,	10,	11,	11,	12,	13,	15,	16,	18,	20,	22,	25,	27,	30,	32,	35,	37,	40,	42,	44,	46,	48,	49,	51,	52,	52,	53,	53,	52,	52,	51,	50,	49,	47,	46,	44,
            13,	12,	11,	10,	9,	8,	8,	7,	8,	8,	9,	10,	11,	13,	15,	17,	19,	22,	24,	27,	29,	32,	34,	37,	39,	42,	44,	45,	47,	48,	49,	50,	50,	51,	50,	50,	49,	48,	47,	45,	44,	42,
            12,	10,	9,	7,	6,	5,	5,	5,	5,	5,	6,	7,	8,	10,	11,	14,	16,	18,	21,	23,	26,	29,	31,	34,	36,	39,	41,	43,	44,	46,	47,	48,	48,	48,	48,	48,	47,	46,	44,	43,	41,	39,
            10,	8,	7,	5,	4,	3,	2,	2,	2,	2,	3,	4,	5,	6,	8,	10,	13,	15,	18,	20,	23,	26,	28,	31,	34,	36,	38,	40,	42,	43,	44,	45,	46,	46,	46,	45,	44,	43,	42,	40,	38,	36,
            8,	6,	5,	3,	2,	1,	0,	0,	0,	0,	0,	1,	2,	3,	5,	7,	9,	12,	14,	17,	20,	23,	25,	28,	31,	33,	35,	37,	39,	40,	42,	42,	43,	43,	43,	42,	41,	40,	39,	37,	35,	33,
            6,	5,	3,	1,	0,	1,	2,	2,	2,	2,	2,	1,	0,	0,	2,	4,	6,	9,	11,	14,	17,	20,	22,	25,	28,	30,	32,	34,	36,	38,	39,	40,	40,	40,	40,	40,	39,	37,	36,	34,	32,	30,
            5,	3,	1,	0,	1,	3,	4,	4,	5,	5,	4,	4,	3,	1,	0,	1,	4,	6,	9,	11,	14,	17,	19,	22,	25,	27,	29,	31,	33,	35,	36,	37,	37,	37,	37,	37,	36,	34,	33,	31,	29,	27,
            4,	1,	0,	1,	3,	5,	6,	6,	7,	7,	7,	6,	5,	4,	2,	0,	1,	3,	6,	9,	11,	14,	17,	19,	22,	24,	27,	29,	30,	32,	33,	34,	34,	34,	34,	34,	33,	31,	30,	28,	26,	24,
            2,	0,	1,	3,	5,	6,	7,	8,	9,	9,	8,	8,	7,	6,	4,	2,	0,	1,	3,	6,	9,	11,	14,	17,	19,	22,	24,	26,	28,	29,	30,	31,	31,	32,	31,	31,	30,	28,	27,	25,	23,	21,
            1,	0,	2,	4,	6,	7,	9,	9,	10,	10,	10,	10,	9,	8,	6,	4,	2,	0,	1,	4,	6,	9,	12,	14,	17,	19,	21,	23,	25,	26,	27,	28,	29,	29,	28,	28,	27,	26,	24,	22,	20,	18,
            1,	1,	3,	5,	7,	8,	10,	11,	11,	11,	11,	11,	10,	9,	8,	6,	4,	2,	0,	2,	4,	7,	10,	12,	14,	17,	19,	21,	22,	24,	25,	26,	26,	26,	26,	25,	24,	23,	21,	19,	17,	15,
            0,	1,	3,	6,	7,	9,	10,	11,	12,	12,	12,	12,	11,	10,	9,	7,	5,	3,	1,	0,	3,	5,	8,	10,	12,	15,	17,	18,	20,	21,	22,	23,	23,	23,	23,	22,	21,	20,	18,	16,	14,	12,
            0,	2,	4,	6,	8,	10,	11,	12,	13,	13,	13,	13,	12,	11,	10,	8,	7,	5,	3,	0,	1,	3,	6,	8,	10,	13,	15,	16,	18,	19,	20,	21,	21,	21,	20,	20,	19,	17,	16,	14,	12,	9,
            0,	2,	4,	6,	8,	10,	11,	12,	13,	14,	14,	13,	13,	12,	11,	9,	8,	6,	4,	2,	0,	2,	4,	7,	9,	11,	13,	14,	16,	17,	18,	18,	19,	18,	18,	17,	16,	15,	13,	11,	9,	7,
            0,	2,	4,	6,	8,	10,	11,	13,	13,	14,	14,	14,	13,	12,	11,	10,	8,	7,	5,	3,	0,	1,	3,	5,	7,	9,	11,	12,	14,	15,	16,	16,	16,	16,	16,	15,	14,	12,	11,	9,	7,	4,
*/

    /** Nur ein Start ist erwünscht*/
    private Coordinate[] smallHillStarts = {
      new Coordinate(0,0)
    };

  private Coordinate[] hill0Starts = {
    new Coordinate(0, 0),
    new Coordinate(hill0.length - 1, 0),
    new Coordinate(hill0.length - 1, hill0[0].length - 1),
    new Coordinate(0, hill0[0].length - 1)
  };

  private Coordinate[] hill1Starts = {
    new Coordinate(hill1.length - 1, 0),
    new Coordinate(hill1.length - 4, 0),
    new Coordinate(0, hill1[0].length - 1)
  };

  /** Nur ein Weg ist möglich, Achtung oben sind die x und y Achsen vertauscht!*/
  private CoordinateTree[] hillSmallTrees = {
    new CoordinateTree(null, new Coordinate(0,0))
    .addChild(new CoordinateTree(null,new Coordinate(1,0)))
    .addChild(new CoordinateTree(null, new Coordinate(1,1)))
    .addChild(new CoordinateTree(null, new Coordinate(2,1)))
    .addChild(new CoordinateTree(null, new Coordinate(3,1)))
  };

  private CoordinateTree[] hill0Trees = {
    new CoordinateTree(null, new Coordinate(0, 0))
      .addChild(new CoordinateTree(null, new Coordinate(1, 0)))
      .addChild(new CoordinateTree(null, new Coordinate(2, 0)))
      .addChild(new CoordinateTree(null, new Coordinate(3, 0)))
      .addChild(new CoordinateTree(null, new Coordinate(4, 0))),
    new CoordinateTree(null, new Coordinate(24, 0)),
    new CoordinateTree(null, new Coordinate(24, 24))
      .addChild(new CoordinateTree(null, new Coordinate(23, 24))),
    new CoordinateTree(null, new Coordinate(0, 24))
      .addChild(new CoordinateTree(null, new Coordinate(1, 24)))
      .addChild(new CoordinateTree(null, new Coordinate(2, 24)))
      .addChild(new CoordinateTree(null, new Coordinate(3, 24)))
  };


  private CoordinateTree[] hill1Trees = {
    new CoordinateTree(null, new Coordinate(41, 0))
      .addChild(new CoordinateTree(null, new Coordinate(41, 1)))
      .addChild(new CoordinateTree(null, new Coordinate(41, 2)))
      .addChild(new CoordinateTree(null, new Coordinate(41, 3)))
      .addChild(new CoordinateTree(null, new Coordinate(41, 4)))
      .addChild(new CoordinateTree(null, new Coordinate(41, 5)))
      .addChild(new CoordinateTree(null, new Coordinate(41, 6)))
      .addChild(new CoordinateTree(null, new Coordinate(41, 7))),
    new CoordinateTree(null, new Coordinate(38, 0))
      .addChild(new CoordinateTree(null, new Coordinate(38, 1)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 2)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 3)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 4)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 5)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 5)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 6)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 7)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 8)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 6)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 6)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 7)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 8)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 7)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 7)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 8)))
      .addChild(new CoordinateTree(null, new Coordinate(38, 8)))
      .addChild(new CoordinateTree(null, new Coordinate(39, 8)))
      .addChild(new CoordinateTree(null, new Coordinate(37, 0))),
    new CoordinateTree(null, new Coordinate(0, 41))
      .addChild(new CoordinateTree(null, new Coordinate(1, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(2, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(3, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(4, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(5, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(6, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(7, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(8, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(9, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(10, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(11, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(12, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(13, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(14, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(15, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(16, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(17, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(17, 40)))
      .addChild(new CoordinateTree(null, new Coordinate(17, 39)))
      .addChild(new CoordinateTree(null, new Coordinate(18, 39)))
      .addChild(new CoordinateTree(null, new Coordinate(19, 39)))
      .addChild(new CoordinateTree(null, new Coordinate(18, 40)))
      .addChild(new CoordinateTree(null, new Coordinate(19, 40)))
      .addChild(new CoordinateTree(null, new Coordinate(19, 39)))
      .addChild(new CoordinateTree(null, new Coordinate(18, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(19, 41)))
      .addChild(new CoordinateTree(null, new Coordinate(19, 40)))
      .addChild(new CoordinateTree(null, new Coordinate(19, 39)))
  };

  private void comparePaths(Coordinate[] path, CoordinateTree pathTree) {
    for (int i = 0; i < path.length; i++) {
      CoordinateTree childTree = pathTree.getChild(path[i]);
      if (childTree == null) {
        if (i == 0) {
          throw new IllegalArgumentException("Start of path and pathTree do not match!");
        }
        fail(String.format("No possible transition from {%d, %d} to {%d, %d}", path[i - 1].x, path[i - 1].y, path[i].x, path[i].y));
      }
    }
  }

  private void hillTest(int[][] hill, Coordinate[] hillStarts, CoordinateTree[] hillTrees) {
    Hillclimber hillclimber = new Hillclimber(hill);
    ClimbListener[] listeners = new ClimbListener[hillStarts.length];
    for (int i = 0; i < listeners.length; i++) {
      listeners[i] = new ClimbListener();
      hillclimber.climb(hillStarts[i], listeners[i]);
      comparePaths(listeners[i].getPath().toArray(new Coordinate[0]), hillTrees[i]);
    }
  }

  @Test
  public void smallHillTest(){
    hillTest(smallHill,smallHillStarts,hillSmallTrees);
  }

  @Test
  public void hill0Test() {
    hillTest(hill0, hill0Starts, hill0Trees);
  }


  @Test
  public void hill1Test() {
    hillTest(hill1, hill1Starts, hill1Trees);
  }

}
