import os
from operator import itemgetter, attrgetter

title_project = "# EveryDay - Practice"

sub_project = "### push 후 자동으로 README 수정 기능"

dic = {}


class Problem:
    def __init__(self, id, week, day, filename, address):
        self.id = id
        self.week = week
        self.day = day
        self.filename = filename
        self.address = address

    def get_week(self):
        return self.week

    def get_day(self):
        return self.day

    def get_filename(self):
        return self.filename

    def __str__(self) -> str:
        return " | " + self.week + " | " + self.day + " | [" + self.filename + "](" + self.address + ")" + "|\n"


def print_files_in_dir(root_dir, prefix, problems):
    value = 1
    global dic
    try:
        for (root, dirs, files) in os.walk(root_dir):
            for filename in files:
                ext = os.path.splitext(filename)[-1]
                if ext == '.java':
                    print("%s %s" % (root, filename))
                    split_dir = root.split(prefix)
                    address = root.replace(prefix, "")
                    address += prefix + filename
                    if len(split_dir) >= 5:
                        username = str(split_dir[2])
                        print(dic)
                        week = str(split_dir[3])


                        if username in dic:
                            if week in dic[username]:
                                dic[username][week] += 1
                            else:
                                dic[username] = dict({week:1},**dic[username])
                        else:
                            dic[username] = dict({week: 1})
                            key = dic[username]
                            if key == None:
                                print("is none")
                            else:
                                dic[username] = dict({week:1})


                        # if(dic.get(username).get(week)):
                        #     print(dic[username][week])
                        # else:
                        #     dic[username] = dic[week] = 1



                        day = str(split_dir[4])
                        filename = str(filename)
                        if week and day and filename:
                            problems.append(Problem(str(value), week, day, filename, address))
                            value += 1
    except PermissionError:
        pass


def make_info_header(dic):
    info = f"| # | week | day |\n"
    info += f"|---|---|---| \n"
    for index in range(0, len(dic)):
        info += f"| {index + 1} | {dic[index][0]} | {dic[index][1]} | \n"
    print(info)
    return info


def make_info_data(problems):
    info = f"### 총 푼 문제수 = {len(problems)} 🎉\n\n"
    info += f"| # | week | day | problem |\n| ------------- | ------------- | ------------- | ------------- |\n"
    for index in range(0, len(problems)):
        temp = f"| {index + 1} {problems[index]}"
        info += temp

    info += """"""
    return info


if __name__ == "__main__":
    problems = []
    personal_dir = "..\\"
    prefix = "\\"
    print_files_in_dir(personal_dir, prefix, problems)
    projects = sorted(problems, key=attrgetter('week', 'day'), reverse=False)

    sorted_koodic = sorted(dic["koo"].items(), key=lambda item: item[0], reverse=False)
    sorted_kimdic = sorted(dic["kim"].items(), key=lambda item: item[0], reverse=False)
    sorted_jidic = sorted(dic["ji"].items(), key=lambda item: item[0], reverse=False)
    sorted_godic = sorted(dic["go"].items(), key=lambda item: item[0], reverse=False)

    print(sorted_koodic)
    print(sorted_kimdic)
    print(sorted_jidic)
    print(sorted_godic)
    info = make_info_data(projects)
    header = make_info_header(sorted_koodic)

    with open("../README.md", 'w', encoding='utf-8') as f:
        f.write(title_project + "\n")
        f.write(sub_project + "\n")
        f.write(header + "\n")
        f.write(info)
        f.close()