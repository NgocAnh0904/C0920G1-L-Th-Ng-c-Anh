async function fetchRepo(): Promise<any> {
    let res: Response = await fetch('https://api.github.com/search/repositories?q=angular');
    res = await res.json();
    return res;
}

async function main() {
    const res = await fetchRepo();
    let name ="";
    res.items.forEach((item: any) => {
        console.log(item.name);
        name += item.name + "</br>";
    });
    document.write(name);
}

main();
