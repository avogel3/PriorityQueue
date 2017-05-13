require_relative 'lib/priority_queue'

queue = PriorityQueue.new
puts "Parsing Input..."
File.readlines("input.txt").each do |line|
  input_args = line.split(" ")

  if(input_args.at(0) == "insert") 
    name = input_args.at(1)
    priority = input_args.at(2).to_i
    queue.insert(name, priority)
  else
    removed_name = queue.remove
    puts removed_name
  end
end
puts "------Finished------"
