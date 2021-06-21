export const formatDate = (stringDate) => {

    var split = stringDate.split(" ");
    var newDate = new Date(split[0]);
    return newDate.toDateString() + " " + split[1];
}
