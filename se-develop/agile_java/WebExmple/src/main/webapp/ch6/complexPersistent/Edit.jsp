<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Edit Page</title>
    </head>
    <body>
        <p>This is a simple HTML page that has a form in it.</p>
        <FORM method="post" action="Controller">
            Secret Code ${helper.errors.secretCode}
            <INPUT type="password" name="secretCode" 
                   value="${helper.data.secretCode}">
            <BR>
            Level of Happiness:
            <INPUT type="radio" name="happiness" value="1" 
                ${helper.checked.happiness["1"]}>Elated
            <INPUT type="radio" name="happiness" value="2" 
                ${helper.checked.happiness["2"]}>Ecstatic
            <INPUT type="radio" name="happiness" value="3" 
                ${helper.checked.happiness["3"]}>Joyous
            <BR>
            Preferred Extras: ${helper.errors.extra}
            <INPUT type="checkbox" name="extra" value="sprinkles" 
                ${helper.checked.extra["sprinkles"]}>Chocolate Sprinkles
            <INPUT type="checkbox" name="extra" value="fudge" 
                ${helper.checked.extra["fudge"]}>Hot Fudge
            <INPUT type="checkbox" name="extra" value="cream" 
                ${helper.checked.extra["cream"]}>Whipped Cream
            <BR>
            Comments
            <TEXTAREA name="comments">${helper.data.comments}</TEXTAREA>
            <BR>
            Grade 
            <SELECT name="grade"> 
                <OPTION value="4.00" ${helper.selected.grade["4.0"]}>A 
                <OPTION value="3.67" ${helper.selected.grade["3.67"]}>A- 
                <OPTION value="3.33" ${helper.selected.grade["3.33"]}>B+ 
                <OPTION value="3.00" ${helper.selected.grade["3.0"]}>B 
                <OPTION value="2.67" ${helper.selected.grade["2.67"]}>B- 
                <OPTION value="2.33" ${helper.selected.grade["2.33"]}>C+ 
                <OPTION value="2.00" ${helper.selected.grade["2.0"]}>C 
            </SELECT> 
            <BR>
            Team ${helper.errors.team}<br>
            <SELECT name="team" multiple size="2"> 
                <OPTION value="heat" ${helper.selected.team["heat"]}>
                    Heat 
                <OPTION value="marlins" ${helper.selected.team["marlins"]}>
                    Marlins 
                <OPTION value="dolphins" ${helper.selected.team["dolphins"]}>
                    Dolphins 
                <OPTION value="panthers" ${helper.selected.team["panthers"]}>
                    Panthers 
            </SELECT> 
            <BR>
            <INPUT type="submit" name="confirmButton" value="Confirm">
        </FORM>
    </body>
</html>
