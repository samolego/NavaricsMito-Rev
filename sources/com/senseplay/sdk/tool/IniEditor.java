package com.senseplay.sdk.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public class IniEditor {
    private static final Line BLANK_LINE = new Line() { // from class: com.senseplay.sdk.tool.IniEditor.1
        @Override // com.senseplay.sdk.tool.IniEditor.Line
        public String toString() {
            return "";
        }
    };
    private static boolean DEFAULT_CASE_SENSITIVITY = false;
    private char[] commentDelims;
    private String commonName;
    private boolean isCaseSensitive;
    private OptionFormat optionFormat;
    private List<String> sectionOrder;
    private Map<String, Section> sections;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface Line {
        String toString();
    }

    public IniEditor() {
        this((String) null, (char[]) null);
    }

    public IniEditor(boolean z) {
        this(null, null, z);
    }

    public IniEditor(String str) {
        this(str, (char[]) null);
    }

    public IniEditor(String str, boolean z) {
        this(str, null, z);
    }

    public IniEditor(char[] cArr) {
        this((String) null, cArr);
    }

    public IniEditor(char[] cArr, boolean z) {
        this(null, cArr, z);
    }

    public IniEditor(String str, char[] cArr) {
        this(str, cArr, DEFAULT_CASE_SENSITIVITY);
    }

    public IniEditor(String str, char[] cArr, boolean z) {
        this.sections = new HashMap();
        this.sectionOrder = new LinkedList();
        this.isCaseSensitive = z;
        if (str != null) {
            this.commonName = str;
            addSection(this.commonName);
        }
        this.commentDelims = cArr;
        this.optionFormat = new OptionFormat(Section.DEFAULT_OPTION_FORMAT);
    }

    public void setOptionFormatString(String str) {
        this.optionFormat = new OptionFormat(str);
    }

    public String get(String str, String str2) {
        if (hasSection(str)) {
            Section section = getSection(str);
            if (section.hasOption(str2)) {
                return section.get(str2);
            }
            String str3 = this.commonName;
            if (str3 != null) {
                return getSection(str3).get(str2);
            }
            return null;
        }
        return null;
    }

    public void set(String str, String str2, String str3) {
        if (hasSection(str)) {
            getSection(str).set(str2, str3);
            return;
        }
        throw new NoSuchSectionException(str);
    }

    public boolean remove(String str, String str2) {
        if (hasSection(str)) {
            return getSection(str).remove(str2);
        }
        throw new NoSuchSectionException(str);
    }

    public boolean hasOption(String str, String str2) {
        return hasSection(str) && getSection(str).hasOption(str2);
    }

    public boolean hasSection(String str) {
        return this.sections.containsKey(normSection(str));
    }

    public boolean addSection(String str) {
        String normSection = normSection(str);
        if (hasSection(normSection)) {
            return false;
        }
        Section section = new Section(normSection, this.commentDelims, this.isCaseSensitive);
        section.setOptionFormat(this.optionFormat);
        this.sections.put(normSection, section);
        this.sectionOrder.add(normSection);
        return true;
    }

    public boolean removeSection(String str) {
        String normSection = normSection(str);
        String str2 = this.commonName;
        if (str2 != null && str2.equals(normSection)) {
            throw new IllegalArgumentException("Can't remove common section");
        }
        if (hasSection(normSection)) {
            this.sections.remove(normSection);
            this.sectionOrder.remove(normSection);
            return true;
        }
        return false;
    }

    public List<String> sectionNames() {
        ArrayList arrayList = new ArrayList(this.sectionOrder);
        String str = this.commonName;
        if (str != null) {
            arrayList.remove(str);
        }
        return arrayList;
    }

    public List<String> optionNames(String str) {
        if (hasSection(str)) {
            return getSection(str).optionNames();
        }
        throw new NoSuchSectionException(str);
    }

    public void addComment(String str, String str2) {
        if (hasSection(str)) {
            getSection(str).addComment(str2);
            return;
        }
        throw new NoSuchSectionException(str);
    }

    public void addBlankLine(String str) {
        if (hasSection(str)) {
            getSection(str).addBlankLine();
            return;
        }
        throw new NoSuchSectionException(str);
    }

    public void save(String str) throws IOException {
        save(new File(str));
    }

    public void save(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        save(fileOutputStream);
        fileOutputStream.close();
    }

    public void save(OutputStream outputStream) throws IOException {
        save(new OutputStreamWriter(outputStream));
    }

    public void save(OutputStreamWriter outputStreamWriter) throws IOException {
        PrintWriter printWriter = new PrintWriter((Writer) outputStreamWriter, true);
        for (String str : this.sectionOrder) {
            Section section = getSection(str);
            printWriter.println(section.header());
            section.save(printWriter);
        }
    }

    public void load(String str) throws IOException {
        load(new File(str));
    }

    public void load(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void load(InputStream inputStream) throws IOException {
        load(new InputStreamReader(inputStream));
    }

    public void load(InputStreamReader inputStreamReader) throws IOException {
        int indexOf;
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        while (bufferedReader.ready()) {
            String trim = bufferedReader.readLine().trim();
            if (trim.length() > 0 && trim.charAt(0) == '[' && (indexOf = trim.indexOf(93)) >= 0) {
                str = trim.substring(1, indexOf);
                addSection(str);
            }
            if (str != null) {
                getSection(str).load(bufferedReader);
            }
        }
    }

    private Section getSection(String str) {
        return this.sections.get(normSection(str));
    }

    private String normSection(String str) {
        if (!this.isCaseSensitive) {
            str = str.toLowerCase();
        }
        return str.trim();
    }

    private static String[] toStringArray(Collection<Object> collection) {
        Object[] array = collection.toArray();
        String[] strArr = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strArr[i] = (String) array[i];
        }
        return strArr;
    }

    /* loaded from: classes2.dex */
    public static class Section {
        private static final boolean DEFAULT_CASE_SENSITIVITY = false;
        public static final String DEFAULT_OPTION_FORMAT = "%s %s %s";
        private static final int NAME_MAXLENGTH = 1024;
        private static final String NEWLINE_CHARS = "\n\r";
        private char[] commentDelims;
        private char[] commentDelimsSorted;
        private boolean isCaseSensitive;
        private List<Line> lines;
        private String name;
        private char[] optionDelims;
        private char[] optionDelimsSorted;
        private OptionFormat optionFormat;
        private Map<String, Option> options;
        private static final char[] DEFAULT_OPTION_DELIMS = {'=', ':'};
        private static final char[] DEFAULT_COMMENT_DELIMS = {'#', ';'};
        private static final char[] OPTION_DELIMS_WHITESPACE = {' ', '\t'};
        public static final char HEADER_START = '[';
        public static final char HEADER_END = ']';
        private static final char[] INVALID_NAME_CHARS = {HEADER_START, HEADER_END};

        public Section(String str) {
            this(str, (char[]) null);
        }

        public Section(String str, boolean z) {
            this(str, null, z);
        }

        public Section(String str, char[] cArr) {
            this(str, cArr, false);
        }

        public Section(String str, char[] cArr, boolean z) {
            if (!validName(str)) {
                throw new IllegalArgumentException("Illegal section name:" + str);
            }
            this.name = str;
            this.isCaseSensitive = z;
            this.options = new HashMap();
            this.lines = new LinkedList();
            this.optionDelims = DEFAULT_OPTION_DELIMS;
            this.commentDelims = cArr == null ? DEFAULT_COMMENT_DELIMS : cArr;
            this.optionFormat = new OptionFormat(DEFAULT_OPTION_FORMAT);
            char[] cArr2 = this.optionDelims;
            this.optionDelimsSorted = new char[cArr2.length];
            System.arraycopy(cArr2, 0, this.optionDelimsSorted, 0, cArr2.length);
            char[] cArr3 = this.commentDelims;
            this.commentDelimsSorted = new char[cArr3.length];
            System.arraycopy(cArr3, 0, this.commentDelimsSorted, 0, cArr3.length);
            Arrays.sort(this.optionDelimsSorted);
            Arrays.sort(this.commentDelimsSorted);
        }

        public void setOptionFormatString(String str) {
            setOptionFormat(new OptionFormat(str));
        }

        public void setOptionFormat(OptionFormat optionFormat) {
            this.optionFormat = optionFormat;
        }

        public List<String> optionNames() {
            LinkedList linkedList = new LinkedList();
            for (Line line : this.lines) {
                if (line instanceof Option) {
                    linkedList.add(((Option) line).name());
                }
            }
            return linkedList;
        }

        public boolean hasOption(String str) {
            return this.options.containsKey(normOption(str));
        }

        public String get(String str) {
            String normOption = normOption(str);
            if (hasOption(normOption)) {
                return getOption(normOption).value();
            }
            return null;
        }

        public void set(String str, String str2) {
            set(str, str2, this.optionDelims[0]);
        }

        public void set(String str, String str2, char c) {
            String normOption = normOption(str);
            if (hasOption(normOption)) {
                getOption(normOption).set(str2);
                return;
            }
            Option option = new Option(normOption, str2, c, this.optionFormat);
            this.options.put(normOption, option);
            this.lines.add(option);
        }

        public boolean remove(String str) {
            String normOption = normOption(str);
            if (hasOption(normOption)) {
                this.lines.remove(getOption(normOption));
                this.options.remove(normOption);
                return true;
            }
            return false;
        }

        public void addComment(String str) {
            addComment(str, this.commentDelims[0]);
        }

        public void addComment(String str, char c) {
            StringTokenizer stringTokenizer = new StringTokenizer(str.trim(), NEWLINE_CHARS);
            while (stringTokenizer.hasMoreTokens()) {
                this.lines.add(new Comment(stringTokenizer.nextToken(), c));
            }
        }

        public void addBlankLine() {
            this.lines.add(IniEditor.BLANK_LINE);
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            while (bufferedReader.ready()) {
                bufferedReader.mark(1024);
                String trim = bufferedReader.readLine().trim();
                if (trim.length() > 0 && trim.charAt(0) == '[') {
                    bufferedReader.reset();
                    return;
                } else if (trim.equals("")) {
                    addBlankLine();
                } else {
                    int binarySearch = Arrays.binarySearch(this.commentDelimsSorted, trim.charAt(0));
                    if (binarySearch >= 0) {
                        addComment(trim.substring(1), this.commentDelimsSorted[binarySearch]);
                    } else {
                        int length = trim.length();
                        int i = -1;
                        int i2 = -1;
                        for (int i3 = 0; i3 < length && i < 0; i3++) {
                            if (Arrays.binarySearch(this.optionDelimsSorted, trim.charAt(i3)) < 0) {
                                boolean z = Arrays.binarySearch(OPTION_DELIMS_WHITESPACE, trim.charAt(i3)) >= 0;
                                if (!z && i2 >= 0) {
                                    break;
                                } else if (z) {
                                    i2 = i3;
                                }
                            } else {
                                i = i3;
                            }
                        }
                        if (i != 0) {
                            if (i >= 0) {
                                set(trim.substring(0, i), trim.substring(i + 1), trim.charAt(i));
                            } else if (i2 < 0) {
                                set(trim, "");
                            } else {
                                set(trim.substring(0, i2), trim.substring(i2 + 1));
                            }
                        }
                    }
                }
            }
        }

        public void save(PrintWriter printWriter) throws IOException {
            for (Line line : this.lines) {
                printWriter.println(line.toString());
            }
            if (printWriter.checkError()) {
                throw new IOException();
            }
        }

        private Option getOption(String str) {
            return this.options.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String header() {
            return HEADER_START + this.name + HEADER_END;
        }

        private static boolean validName(String str) {
            if (str.trim().equals("")) {
                return false;
            }
            int i = 0;
            while (true) {
                char[] cArr = INVALID_NAME_CHARS;
                if (i >= cArr.length) {
                    return true;
                }
                if (str.indexOf(cArr[i]) >= 0) {
                    return false;
                }
                i++;
            }
        }

        private String normOption(String str) {
            if (!this.isCaseSensitive) {
                str = str.toLowerCase();
            }
            return str.trim();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Option implements Line {
        private static final String ILLEGAL_VALUE_CHARS = "\n\r";
        private OptionFormat format;
        private String name;
        private char separator;
        private String value;

        public Option(String str, String str2, char c, OptionFormat optionFormat) {
            if (!validName(str, c)) {
                throw new IllegalArgumentException("Illegal option name:" + str);
            }
            this.name = str;
            this.separator = c;
            this.format = optionFormat;
            set(str2);
        }

        public String name() {
            return this.name;
        }

        public String value() {
            return this.value;
        }

        public void set(String str) {
            if (str == null) {
                this.value = str;
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str.trim(), ILLEGAL_VALUE_CHARS);
            StringBuffer stringBuffer = new StringBuffer();
            while (stringTokenizer.hasMoreTokens()) {
                stringBuffer.append(stringTokenizer.nextToken());
            }
            this.value = stringBuffer.toString();
        }

        @Override // com.senseplay.sdk.tool.IniEditor.Line
        public String toString() {
            return this.format.format(this.name, this.value, this.separator);
        }

        private static boolean validName(String str, char c) {
            return !str.trim().equals("") && str.indexOf(c) < 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Comment implements Line {
        private static final char DEFAULT_DELIMITER = '#';
        private String comment;
        private char delimiter;

        public Comment(String str) {
            this(str, DEFAULT_DELIMITER);
        }

        public Comment(String str, char c) {
            this.comment = str.trim();
            this.delimiter = c;
        }

        @Override // com.senseplay.sdk.tool.IniEditor.Line
        public String toString() {
            return this.delimiter + " " + this.comment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class OptionFormat {
        private static final int EXPECTED_TOKENS = 4;
        private String[] formatTokens;

        public OptionFormat(String str) {
            this.formatTokens = compileFormat(str);
        }

        public String format(String str, String str2, char c) {
            String[] strArr = this.formatTokens;
            return strArr[0] + str + strArr[1] + c + strArr[2] + str2 + strArr[3];
        }

        private String[] compileFormat(String str) {
            String[] strArr = {"", "", "", ""};
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != '%') {
                    if (charAt != 's') {
                        if (z) {
                            throw new IllegalArgumentException("Illegal option format. Unknown format specifier.");
                        }
                        stringBuffer.append(str.charAt(i2));
                    } else if (!z) {
                        stringBuffer.append("s");
                    } else if (i >= 4) {
                        throw new IllegalArgumentException("Illegal option format. Too many %s placeholders.");
                    } else {
                        strArr[i] = stringBuffer.toString();
                        i++;
                        stringBuffer = new StringBuffer();
                        z = false;
                    }
                } else if (z) {
                    stringBuffer.append("%");
                    z = false;
                } else {
                    z = true;
                }
            }
            if (i != 3) {
                throw new IllegalArgumentException("Illegal option format. Not enough %s placeholders.");
            }
            strArr[i] = stringBuffer.toString();
            return strArr;
        }
    }

    /* loaded from: classes2.dex */
    public static class NoSuchSectionException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public NoSuchSectionException() {
        }

        public NoSuchSectionException(String str) {
            super(str);
        }
    }
}
