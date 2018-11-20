/*
 * File:	Process.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti
 * Date: 	November, 2018
 */

import java.util.*;

public class FCFS {

	// The list of processes to be scheduled
	public ArrayList<Process> processes;

	// Class constructor
	public FCFS(ArrayList<Process> processes) {
		this.processes = processes;
	}

	public void run() {
		processes.sort(comparator);

		int CPUTimer = 0;
		int i = 0;
		int workload = processes.size();
		int activeBurstTime = 0;

		Process active = null;
        ArrayDeque<Process> q = new ArrayDeque<>();

        Process nextProcess = processes.get(i);

		while (workload > 0) {
            if (nextProcess.getArrivalTime() <= CPUTimer) {
                if (!q.contains(nextProcess)) {
                    q.addLast(nextProcess);

                    i++;
                    if (i < processes.size()) {
                        nextProcess = processes.get(i);
                    }
                }
            }

            if (active == null) {
                try {
                    active = q.removeFirst();
                    activeBurstTime = active.getBurstTime();
                } catch (Exception ignored) {

                }
            }

            activeBurstTime--;
            CPUTimer++;
            if (activeBurstTime == 0 && active != null) {
                calculateCompletedTime(active, CPUTimer);
                calculateTurnaroundTime(active);
                calculateWaitingTime(active);

                active = null;
                workload--;
            }
        }

		printTable();
		printGanttChart();
	}

	public void printTable() {
		StringBuilder table = new StringBuilder("\n\n------------------------------------------\nPID		AT		BT		CT		TAT		WT");
		for (Process p : processes) {
			table.append("\n")
					.append(p.getProcessId())
					.append("		")
					.append(p.getArrivalTime())
					.append("		")
					.append(p.getBurstTime())
					.append("		")
					.append(p.getCompletedTime())
					.append("		")
					.append(p.getTurnaroundTime())
					.append("		")
					.append(p.getWaitingTime());
		}
		table.append("\n------------------------------------------\n\n");
		System.out.print(table.toString());
	}

	public void printGanttChart() {
		StringBuilder gantz = new StringBuilder();

		//Print first line
		printPrettyLine(gantz);

		//Print second line
		printProcess(processes.get(0), gantz);
		for (int i = 1; i < processes.size(); i++) {
			Process current = processes.get(i);
			Process previous = processes.get(i - 1);

			if (current.getArrivalTime() <= previous.getCompletedTime()) {
				printProcess(current, gantz);
			} else {
				int idleTime = current.getArrivalTime() - previous.getCompletedTime();
				for (int j = 0; j < idleTime; j++) {
					gantz.append("*");
				}
				printProcess(current, gantz);
			}
		}

		//Print third line
		gantz.append("\n");
		printPrettyLine(gantz);


		//Print fourth line
		printNumber(processes.get(0).getArrivalTime(),
								processes.get(0).getCompletedTime(),
								processes.get(0).getBurstTime(),
								gantz);
		for (int i = 1; i < processes.size(); i++) {
			Process current = processes.get(i);
			Process previous = processes.get(i - 1);

			if (current.getArrivalTime() <= previous.getCompletedTime()) {
				printNumber(-1, current.getBurstTime(), current.getCompletedTime(), gantz);
			} else {
				int idleTime = current.getArrivalTime() - previous.getCompletedTime();
				for (int j = 0; j < idleTime; j++) {
					gantz.append(" ");
				}

				printNumber(current.getArrivalTime(), current.getBurstTime(), current.getCompletedTime(), gantz);
			}
		}

		System.out.println(gantz.toString());
	}

	private void printPrettyLine(StringBuilder gantz) {
		int total = processes.get(processes.size() - 1).getCompletedTime() + (6 * processes.size()) - 2;
		for (int i = 0; i < total; i++) {
			gantz.append("=");
		}
		gantz.append("\n");
	}

	private void printProcess(Process p, StringBuilder gantz) {
		gantz.append("|");

		for (int i = 0; i < (p.getBurstTime() / 2); i++) {
			gantz.append(" ");
		}
		gantz.append(" P").append(p.getProcessId()).append(" ");
		for (int i = 0; i < (p.getBurstTime() / 2); i++) {
			gantz.append(" ");
		}

		gantz.append("|");
	}

	private void printNumber(int start, int length, int end, StringBuilder gantz) {
		StringBuilder spaces = new StringBuilder();
		if (start >= 0)
			gantz.append(start);

		if (start > 10) {
			spaces.append(" ");
		} else {
			spaces.append("  ");
		}

		if (end > 10) {
			spaces.append(" ");
		} else {
			spaces.append("  ");
		}

		for (int i = 0; i < length; i++) {
			spaces.append(" ");
		}
		gantz.append(spaces.toString());
		gantz.append(end);
	}

	private void calculateCompletedTime(Process p, int ct) {
		p.setCompletedTime(ct);
	}

	private void calculateTurnaroundTime(Process p) {
		int tat = p.getCompletedTime() - p.getArrivalTime();
		p.setTurnaroundTime(tat);
	}

	private void calculateWaitingTime(Process p) {
		int wt = p.getTurnaroundTime() - p.getBurstTime();
		p.setWaitingTime(wt);
	}

	private Comparator<Process> comparator = Comparator.comparingInt(Process::getArrivalTime);
}
