package ru.academits.ivanov.rangeModified;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return x >= from && x <= to;
    }

    public Range getRangeCrossing(Range range) {
        if (this.from >= range.getTo() || range.getFrom() >= this.to) {
            throw new IllegalArgumentException("null");
        }

        return new Range(Math.max(this.from, range.getFrom()), Math.min(this.to, range.getTo()));
    }

    public Range[] getRangeMerging(Range range) {
        if (this.to < range.getFrom()) {
            return new Range[]{new Range(this.from, this.to), new Range(range.getFrom(), range.getTo())};
        } else if (this.from > range.getTo()) {
            return new Range[]{new Range(range.getFrom(), range.getTo()), new Range(this.from, this.to)};
        }

        return new Range[]{new Range(Math.min(this.from, range.getFrom()), Math.max(this.to, range.getTo()))};
    }

    public Range[] getRangeDifference(Range range) {
        if (this.from >= range.getFrom() && this.from < range.getTo() && this.to > range.getTo()) {
            return new Range[]{new Range(range.getTo(), this.to)};
        } else if (this.from < range.getFrom() && this.to > range.getFrom() && this.to <= range.getTo()) {
            return new Range[]{new Range(this.from, range.getFrom())};
        } else if (this.to <= range.getFrom() || this.from >= range.getTo()) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (this.from < range.getFrom() && this.to > range.getTo()) {
            return new Range[]{new Range(this.from, range.getFrom()), new Range(range.getTo(), this.to)};
        }

        return new Range[]{};
    }

    @Override
    public String toString() {
        return "[" + from + " : " + to + "]";
    }
}