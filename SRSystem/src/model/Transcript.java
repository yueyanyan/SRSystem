package model;

import java.util.ArrayList;

public class Transcript {
	private ArrayList<TranscriptEntry> transcriptEntries;
	private Student studentOwner;

	public Transcript(Student s) {
		setStudentOwner(s);

		transcriptEntries = new ArrayList<TranscriptEntry>();
	}

	public Transcript() {
	}

	public void setStudentOwner(Student s) {
		studentOwner = s;
	}

	public Student getStudentOwner() {
		return studentOwner;
	}

	public ArrayList<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}

	public boolean verifyCompletion(Course c) {
		boolean outcome = false;

		for (TranscriptEntry te : transcriptEntries) {
			Section s = te.getSection();

			if (s.isSectionOf(c)) {
				if (TranscriptEntry.passingGrade(te.getGrade())) {
					outcome = true;
					break;
				}
			}
		}
		return outcome;
	}

	public void addTranscriptEntry(TranscriptEntry te) {
		transcriptEntries.add(te);
	}
}
