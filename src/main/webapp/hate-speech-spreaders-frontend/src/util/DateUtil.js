export const formatDate = (string) => {

    const options = {day: 'numeric', month: 'long', year: 'numeric'};

    return new Date(string).toLocaleDateString([],options);
}

export const getCurrentDate = () => {
    return new Date().toISOString().split('T')[0];
}