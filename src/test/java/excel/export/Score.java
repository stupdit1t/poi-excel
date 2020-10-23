package excel.export;

/**
 * 得分
 *
 * @author: 李涛
 * @version: 2020年10月23日 14:31
 */
public class Score {

	private Double score;

	private Double avg;

	public Score(Double score, Double avg) {
		this.score = score;
		this.avg = avg;

	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}
}
